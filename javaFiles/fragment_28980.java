try {
            Class.forName(dbDriver);
            dbConnection = DriverManager.getConnection(dbURL, dbURL, dbPassword);
        } catch (ClassNotFoundException cnfe) {
            // TODO Class Exception
        } catch (SQLException sqle) {
            // TODO SQL Exception
        }