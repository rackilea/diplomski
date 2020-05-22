try {
            Class.forName(dbDriver);
            dbConnection = DriverManager.getConnection(dbURL, dbURL, dbPassword);
        } catch (ClassNotFoundException cnfe) {
           cnfe.printStacktrace();
        } catch (SQLException sqle) {
            sqle.printStacktrace();
        }