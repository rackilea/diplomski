public void Create(String first, String last, String email, String address, String username, String password) {
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            Class.forName(JDBC_DRIVER).newInstance();
            conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            StringBuilder query = new StringBuilder("INSERT INTO person(firstName, lastName, email, address, userName, password) VALUES(")
                .append("'").append(first).append("',")
                .append("'").append(last).append("',")
                .append("'").append(email).append("',")
                .append("'").append(address).append("',")
                .append("'").append(username).append("',")
                .append("'").append(password).append("'")
                .append(")");

            System.out.println( query.toString());

            statement = conn.prepareStatement( query.toString() );
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (statement != null) {
                statement.close();
            }

            if (conn != null) {
                conn.close();
            }

        }
    }