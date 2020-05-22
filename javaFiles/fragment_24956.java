try{
    connection.setAutoCommit(false);
    // add to batch and execute batch
    connection.commit();
    } catch (SQLException e) {
      e.printStackTrace();
    }
finally{
   //closing statements
   }