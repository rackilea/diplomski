public static void main (String args []){

  YourClass yourInstance = new YourClass ();

ResultSet tempResultSet = yourInstance.getEntry();
   while( tempResultSet .next() ){
   System.out.println(res.getInt("uid"));
        System.out.println(res.getString("uname"));
        System.out.println(res.getString("pwd"));
        System.out.println(res.getString("mail"));
        System.out.println(res.getInt("rank"));
        System.out.println(res.getInt("coins"));
        System.out.println(res.getString("stg"));
  }

  yourInstance .stmt.close() ; // this is assuming stmt is public
  yourInstance.tempResultSet.close()

}