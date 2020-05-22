package com.DBbean;

 import java.io.IOException;
 import java.io.PrintWriter;
 import java.io.StringWriter;
 import java.sql.Connection;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.ArrayList;
 import java.util.Map;
 import java.util.concurrent.ConcurrentMap;
 import javax.naming.Context;
 import sslog4java.Logger;
 import com.google.common.collect.MapMaker;

 public class DBEngine {

      private Pool pool = null;
      private Connection con = null;
      private Logger fLogger;

      public DBEngine(Context initCtx, Logger logr) throws SQLException{
           this.fLogger = logr;
           // passed the servlet context into the Pool.java
           this.pool = new Pool(initCtx);
           this.con = pool.getConnection();
      }

      public String DBdebug(){

           Connection conn = pool.getConnection();

           try {
                String ps = SQLPS.debugSQL;
                PreparedStatement ps2 = conn.prepareStatement(ps);
                ResultSet rs = ps2.executeQuery();

                if(rs.next()){
                     return "Success";
                } else return "Fail";

           } catch (SQLException e) {
                e.printStackTrace();
           }

           return null;
      }
 }