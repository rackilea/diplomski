List<String> foodorderList = new ArrayList<String>();
...

try {
     myStmt = myConn.createStatement();
     myRs = myStmt.executeQuery("SELECT description FROM orders,menu WHERE code = menu_CODE");

     while (myRs.next()) {
         foodorderList.add(myRs.getString("description"));
     }
}
finally{
     close(myStmt, myRs);
}
return foodorderList.toArray(new String[1]);