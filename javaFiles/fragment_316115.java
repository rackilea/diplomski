String stm = "{call myDB.dbo.StoredPorcQuery (?,?,?,?,?,?,?,?,?,?,?,?)}";
try {   
        ps = con.prepareStatement(stm);
        ps.setString(1, fb.getModel_nu());
        --------
        rs = ps.executeQuery();