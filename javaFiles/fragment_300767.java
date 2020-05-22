public void verify(DataSource ds) {
        boolean throwException = false;
        Contexts contexts = new Contexts("");
        for(LiquibaseConfiguration c : configs) {
            try(Connection con = ds.getConnection()) {
                    Database db = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(con));
                    db.setDatabaseChangeLogLockTableName(c.changeLogLockTableName());
                    db.setDatabaseChangeLogTableName(c.changeLogTableName());
                    Liquibase liquibase = new ShureviewNonCreationLiquibase(c.liquibaseResource(), new ClassLoaderResourceAccessor(), db);
                    liquibase.getLog();
                    liquibase.validate();
                    List<ChangeSet> listUnrunChangeSets = liquibase.listUnrunChangeSets(contexts, new LabelExpression());

                    if(!listUnrunChangeSets.isEmpty()) {
                        StringWriter writer = new StringWriter();
                        liquibase.update(contexts, writer);
                        liquibase.futureRollbackSQL(writer);
                        log.warn(writer.toString());
                        throwException = true;
                    }
            } catch (SQLException | LiquibaseException e) {
                throw new RuntimeException("Failed to verify database.", e);
            }
        }

        if(throwException){
            throw new RuntimeException("Unrun changesets in chengelog.");
        }
    }