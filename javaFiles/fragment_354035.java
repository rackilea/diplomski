PreparedStatement prest = myConn.prepareStatement(
    "insert into QuickTicket (issueDate , pssngr_id , trip_number) values(to_date(?, 'YYYY/MM/DD'),?,?)") ;

String s = "2016/12/25" ;

prest.setString(1, s);
...