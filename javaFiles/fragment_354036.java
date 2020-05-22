PreparedStatement prest = myConn.prepareStatement(
    "insert into QuickTicket (issueDate , pssngr_id , trip_number) values(?,?,?)") ;

String s = "2016-12-25" ;

prest.setDate(1, java.sql.Date.valueOf(s));
...