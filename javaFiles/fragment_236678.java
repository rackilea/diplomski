PreparedStatement statement1 = null;
  PreparedStatement statement2 = null;
  Connection connection=null;

    try {
        //1. Obtain connection and set `false` to autoCommit
        connection.setAutoCommit(false);
        //2. Prepare and execute statements
        statement1=connection.prepareStatement(sql1);
        statement2=connection.prepareStatement(sql2);
        ...
        //3. Execute the statements

        statement1.executeUpdate();
        statement2.executeUpdate();

        //4. Commit the changes

        connection.commit();
        }
    } catch (SQLException e ) {
        if (connection!=null) {
            try {
                connection.rollback();
            } catch(SQLException excep) {}
        }
    }finally {
        if (statement1 != null) {
            statement1.close();
        }
        if (statement2 != null) {
            statement2.close();
        }
       if(connection != null){
          connection.setAutoCommit(true);
          connection.close();
        }
   }