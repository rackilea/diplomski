public void saveShellDB() throws ClassNotFoundException, IOException { 
        Class.forName(classForName); 
        Connection connection = null; 
        try 
        { 
          // create a database connection 
          connection = DriverManager.getConnection(connectionPath); 
          Statement statement = connection.createStatement(); 
          statement.setQueryTimeout(30);  // set timeout to 30 sec. 
          File file = new File("shell.txt"); 
          FileInputStream fis = new FileInputStream(file); 
          PreparedStatement ps = connection.prepareStatement("INSERT INTO shell (name, shl) VALUES (?, ?)"); 
          ps.setString(1, file.getName()); 
          ps.setBinaryStream(2, fis, (int)file.length()); 
          ps.executeUpdate(); 
          ps.close(); 
          fis.close(); 


          System.out.println("SQL save done"); 
        } 
        catch(SQLException e) 
        { 
          // if the error message is "out of memory", 
          // it probably means no database file is found 
          System.err.println(e.getMessage()); 
        } 
        finally 
        { 
          try 
          { 
            if(connection != null) 
              connection.close(); 
          } 

          catch(SQLException e) 
          { 
            // connection close failed. 
            System.err.println(e); 
          } 
        } 
      } 


    public void loadShellDB() throws ClassNotFoundException, SQLException, IOException { 
            Class.forName(classForName); 
        Connection conn = DriverManager.getConnection(connectionPath); 

        String sql = "SELECT name, shl FROM shell"; 
        PreparedStatement stmt = conn.prepareStatement(sql); 
        ResultSet resultSet = stmt.executeQuery(); 
        while (resultSet.next()) { 
          File shl = new File(fileOutputPath); 
          FileOutputStream fos = new FileOutputStream(shl); 

          byte[] buffer = new byte[1];         
          InputStream is = resultSet.getBinaryStream(2); 
          while (is.read(buffer) > 0) { 
            fos.write(buffer); 
          } 
          fos.close(); 
        } 
        conn.close(); 
        System.out.println("SQL Load Done"); 
      }