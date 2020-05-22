public class Prog {

    // static variables ---------------------------------------------------
    static Connection conn;
    static ResultSet row;

    // main ---------------------------------------------------------------
    public static void main(String[] args) {

       // connect to db ---------------------------------------------------
       try {
          DBConnect cl_conn = new DBConnect();
          conn = cl_conn.f_connect();
       } catch(Exception log) {
          System.out.println("FAIL")
       }

       // prepare statements ----------------------------------------------
       SQLPrep prep = new SQLPrep(conn);

       // execute statement 01 --------------------------------------------
       try {
          prep.users_sel.setInt(1, 2);           // pass values to stmnt
          row = prep.users_sel.executeQuery();   // execute stmnt
       } catch(SQLException log) {
          System.out.println("FAIL");
       }

    }

}

class DBConnect {
   ***code to connect to db***
}

// all prepared stmnts in one place ----------------------------------------
class SQLPrep {

   static PreparedStatement users_sel = null;    // select from users
   static PreparedStatement access_sel = null;   // select from access

   try {

      sp_sql = "SELECT * FROM USERS WHERE u_id = ?";
      users_sel = conn.prepareStatement(sp_sql);

      sp_sql = "SELECT * FROM ACCESS WHERE a_id = ?";
      access_sel = conn.prepareStatement(sp_sql);

   } catch(SQLException log) {
      System.out.println("FAIL");
   }

}