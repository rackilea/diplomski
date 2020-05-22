CallableStatement stmt = conn.prepareCall("BEGIN getLogs(?, ?, ?); END;");
      stmt.setInt(1, 0);
      stmt.setInt(2, 0);
      stmt.registerOutParameter(3, OracleTypes.CURSOR);
      stmt.execute();
      ResultSet rs = ((OracleCallableStatement)stmt).getCursor(3);
      while (rs.next()) {
        ;
       //here build your Map, list or whatever you want
      }