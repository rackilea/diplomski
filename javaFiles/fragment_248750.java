static {
   try{
       Class.forName("com.mysql.jdbc.Driver");
   }catch(Exception ex) { 
       System.err.println(ex);
   }
 }