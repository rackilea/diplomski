//Write the SQL query with ? to bind the parameters in PreparedStatement
    String query = "UPDATE user SET password = ? WHERE username = ?";
    PreparedStatement pstmt = null;

    try{
      //create the PreparedStatement object
      pstmt = con.prepareStatement(query);

      //bind the input parameters using setString()
      pstmt.setString(1, newPassword);
      pstmt.setString(2, us);

      //execute the prepare statement now
      int i = pstmt.executeUpdate(query);

      if(i!=0){
          JOptionPane.showMessageDialog(null, "Your password 
                                      is successfully changed!");
      }
      else{
       JOptionPane.showMessageDialog(null, 
              "Ooopps! I guess you should call your programmer. ^^");
      }

  } catch(Exception e){
      System.out.println(e);
  } finally {
        if(pstmt != null)
              pstmt.close();
        if(con != null)
              con.close();
  }