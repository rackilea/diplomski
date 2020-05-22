public void saveLog(String context) throws ClassNotFoundException, IOException {
        Class.forName(classForName);
        Connection connection = null;
        logger.info(context);

        try
        {
          // create a database connection
          connection = DriverManager.getConnection(connectionPath); 
          //connectionPath is the path to my database

          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.

          File file = new File("audit.log"); 
          FileInputStream fis = new FileInputStream(file);

          PreparedStatement ps = connection.prepareStatement("UPDATE OR REPLACE shell SET audit=? WHERE name='shell.txt'"); 
          //shell is the name of my sqlite table

          ps.setBinaryStream(1, fis, (int)file.length());

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