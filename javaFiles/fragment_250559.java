public ResultSet searchSubs(String name, String surname, String belonging, String country){
    try {
        String query = "SELECT * FROM user WHERE 1=1";
        //---------------------------------------^^^
        int index = 1;
        if (!name.isEmpty()) {
            query += " AND firstName = ?";
        }
        if (!surname.isEmpty()) {
            query += " AND surname = ?";
        }
        if (!belonging.isEmpty()) {
            query += " AND belonging = ?";
        }

        if (!country.isEmpty()) {
            query += " AND country = ?";
        }

        PreparedStatement ps = connection.prepareStatement(query);

        if (!name.isEmpty()) {
            ps.setString(index++, name);
        }
        if (!surname.isEmpty()) {
            ps.setString(index++, surname);
        }
        if (!belonging.isEmpty()) {
            ps.setString(index++, belonging);
        }
        if (!country.isEmpty()) {
            ps.setString(index++, country);
        }

        ResultSet rs = ps.executeQuery();
        //...