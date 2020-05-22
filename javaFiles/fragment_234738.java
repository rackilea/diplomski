ct = con.prepareCall("{? = call test_sp (?,?)}");
    ct.registerOutParameter(1, java.sql.Types.INTEGER);
    ct.setInt(2, 1);
    ct.setString(3, "divya");
    ct.execute();

    returnCode = ct.getInt(1);