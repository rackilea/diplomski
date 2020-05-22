PreparedStatement ps = con.prepareStatement(insertsql, new String[]{"isbn"}) 
            //put the name of the primary key column
    ps.executeUpdate();

    rs = ps.getGeneratedKeys();
    if (rs.next()) {
        generatedKey = rs.getString(1);
    }