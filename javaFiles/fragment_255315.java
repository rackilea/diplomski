public List<String> getEmpLastName(String name) {
        List<String> list = new ArrayList();
        Connection conn = createConnection();

        try {
            String query = "SELECT last_name "
                            + "FROM employees "
                            + "WHERE first_name = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);            
            ResultSet results = ps.executeQuery();

            while (results.next()) {
                list.add(results.getString("last_name"));
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