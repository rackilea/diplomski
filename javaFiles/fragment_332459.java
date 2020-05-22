public int getIID(String msgNr) {
    int accid=0;
    try {
        Statement accidStmt = conn.createStatement();
        String accidQuery = "select accid from accounts where name='" + clientname + "'";
        ResultSet accidResult = accidStmt.executeQuery(accidQuery);
        while (accidResult.next())
            accid = accidResult.getInt("accid");
        accidResult.close();
        accidStmt.close();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    int iid = 0;
    try {
        String iidQuery = "select iid from original where accid=? and msg_number=?";
        PreparedStatement pst=conn.prepareStatement(iidQuery);  
        pst.setInt(1,accid);
        pst.setInt(2,Integer.parseInt(msgNr));

        ResultSet iidResult=pst.executeQuery();  
        while (iidResult.next())
            iid = iidResult.getInt("iid");
        iidResult.close();
        iidStmt.close();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }

    return iid;
}