public static ArrayList getSend(){

  Connection conn = null;
  Statement  stmt = null;
  ResultSet res = null;
  List<String> senders =  new ArrayList<String>();

  try{
    conn = DriverManager.getConnection("DBUrl");
    stmt = con.createStatement();
    res = stmt.executeQuery("SELECT * FROM senderTable");

    while (res.next()){
        String send = res.getString(2);
        senders.add(send);

    }
  }catch (Exception e ){
    System.out.println("getSend "+e);
    return null;
  }
 return senders;
}