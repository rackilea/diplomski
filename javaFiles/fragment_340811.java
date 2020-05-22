DatabaseMetaData meta = con.getMetaData();
        ResultSet rs1 = meta.getTables(null, null, null,new String[] {"TABLE"});
        ResultSet rs2 = meta.getTables(null, null,"%", null);
        System.out.println("One way of Listing Tables");
        while (rs1.next())
        {
        System.out.println(rs1.getString("TABLE_NAME"));
        }
        System.out.println("Another way of Listing Tables");
        while(rs2.next())
        {
        System.out.println(rs2.getString(3));                
        }