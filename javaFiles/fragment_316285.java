package com.DBbean;

 import java.sql.Connection;
 import java.sql.SQLException;
 import javax.naming.Context;
 import javax.naming.NamingException;
 import javax.sql.DataSource;

 public class Pool {

      Context ctx;

      public Pool(Context context){
           ctx = context;
      }


     public Connection getConnection() {

           try {
                DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/postgres4" );
                return ds.getConnection();
           } catch (SQLException | NamingException sne) {
                sne.printStackTrace();
                return null;
           }
     }
 }