String url = 
     "jdbc:db2://sysmvs1.stl.ibm.com:5021/STLEC1" +
     ":user=dbadm;password=dbadm;" +
     "specialRegisters=CURRENT_PATH=SYSIBM,CURRENT CLIENT_USERID=test" + ";";
    Connection con = 
       java.sql.DriverManager.getConnection(url);