public List<String> getEmpFirstName() {
        List<String> list = new ArrayList();
        Connection conn = createConnection();

        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT DISTINCT first_name "
                            + "FROM hr.employees "
                            + "ORDER BY first_name";
            ResultSet results = stmt.executeQuery(query);

            while (results.next()) {
                list.add(results.getString("first_name"));
            }
        } catch (Exception e) {
            System.out.println("Exception = " + e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }                    
            }
        }
        return list;
    }