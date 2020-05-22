String sql = "SELECT * FROM customer c JOIN company cmp ON c.company_idcompany = cmp.idcompany";

        ResultSet rs = stmt.executeQuery(sql);
        //STEP 5: Extract data from result set
        while (rs.next()) {
            //Retrieve this from customer table
            int id = rs.getInt("idcustomer");
            //Retrieve this from customer table
            String username = rs.getString("company_username");

            //Display values
            System.out.println("ID: " + id);
            System.out.println("Username: " + username);
        }