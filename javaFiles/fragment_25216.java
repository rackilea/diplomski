try {
      statement.executeUpdate();
   } catch(SQLException e) {
      if (!se.getSQLState().equals("SPECIAL_EXCEPTION") ) {
            fail();
      }
   }