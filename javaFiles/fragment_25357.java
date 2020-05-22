import org.postgresql.jdbc2.optional.SimpleDataSource;
        ...
        SimpleDataSource dataSource = new SimpleDataSource();
        dataSource.setDatabaseName(dbName);
        dataSource.setPortNumber(port);
        dataSource.setUser(username);
        dataSource.setPassword(password);


        ic.bind("java:/comp/env/jdbc/nameofmyjdbcresource", dataSource);