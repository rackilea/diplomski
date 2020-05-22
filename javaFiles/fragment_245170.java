String query="select *
               from sysobjects
          where type ="+"'"+TR+"'";
      stmt = con.createStatement();
       ResultSet rs = 
        stmt.executeQuery(query);