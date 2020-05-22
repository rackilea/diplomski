Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    ((PatternLayout) getLayout()).setConversionPattern(getSql());
                    final String sqlClause = getLayout().format(event);
                    getStatement().executeUpdate(sqlClause);
                    getConnection().commit();
                } catch (final SQLException e) {
                    errorHandler.error(e.toString());
                } finally {
                    close();
                }
            }
        };
        t.run();