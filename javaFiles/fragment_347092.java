ResultSet word;

Statement query=null;

String getData="SELECT THEWORD FROM MAINTAB";
try{
    System.out.println(dbconn.getAutoCommit());
    query = dbconn.createStatement();
    word = query.executeQuery(getData);


    dbconn.setAutoCommit(false);
    System.out.println(dbconn.getAutoCommit());

    for(;word.next();)
        System.out.println(word.getString(1));

}catch(Throwable e){
    System.out.println("Table fetch failed or result data failed");
} finally{
    if(query!=null) {
        try {
             query.close();
        }
        catch(SQLException ex) {
              System.out.println("Could not close query");
        }
   }
}