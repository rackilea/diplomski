con.setAutoCommit(false);
        PreparedStatement ps, ps1 = null;
        ResultSet rs = null;
        Statement st = null;

        String SEL_QUERY = "select item_id from test";
        String UPDATE_QUERY = "insert into test_t values(?)";
        String DELETE_QUERY = "delete from test";

        st = con.createStatement();
        ps = con.prepareStatement(SEL_QUERY);
        rs = ps.executeQuery();
        ps1 = con.prepareStatement(UPDATE_QUERY);

        while (rs.next())
        {

            String id = rs.getString("item_id");
            System.out.println(" item_id : " + id);
            ps1.setString(1, id);
            ps1.addBatch();
        }

        ps1.executeBatch();
        st.execute(DELETE_QUERY);

        con.commit();
        con.close();