PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM 
         SMD_RESERVATION_INSTANCES WHERE id = ?");         
   prepareStatement.setString(1, localIDTest);
   ResultSet rset = prepareStatement.executeQuery();
   prepareStatement.executeUpdate();
   //prepareStatement.close();
   con.commit();