Statement s1 = con.createStatement();
    ResultSet rs1 = s1.executeQuery("SELECT * FROM garantee WHERE loanapplicationid ='" + applicationid + "'");
    ResultSetMetaData garanteeMetaData = rs1.getMetaData();
    int garanteeColumns = garanteeMetaData.getColumnCount();
    HashMap<String, String> garanteeFull = new HashMap<String, String>();
    int j = 1;
    while (rs1.next()) {

        for (int i = 1; i < garanteeColumns; i++) {
            garanteeFull.put(garanteeMetaData.getColumnLabel(i) + j, rs1.getString(i));
            System.out.println(rs1.getString(i));
        }
        j++;
    }