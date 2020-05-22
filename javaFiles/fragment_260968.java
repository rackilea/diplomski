private Connection connectToDB() {
        final String dbHost = "url";

        try {
            String dbConnect = "jdbc:informix-sqli://" + dbHost + ":port/databasename";
            Class.forName("com.informix.jdbc.IfxDriver").newInstance();
            return DriverManager.getConnection(dbConnect, "user", "passwort");

        } catch (Throwable e) {
            return null;
        }
        return null;
    }