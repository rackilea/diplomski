if (id.startsWith("200")){
      try (PreparedStatement pstmt = conn.prepareStatement("UPDATE patient SET patient_passwort=? WHERE patient_id=?");) {
          pstmt.setString(1, newpass1);
          pstmt.setString(2, id);
          int rows = pstmt.executeUpdate();

          JOptionPane.showMessageDialog(this , "Successfully changed", 
             "Patient password successfuly changed! (updated rows: "+rows+")", JOptionPane.PLAIN_MESSAGE);
       }
    }