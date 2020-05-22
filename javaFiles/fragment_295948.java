try {
    Connection c = DBConnection.dbconmethod();
    Statement s = c.createStatement();
    ResultSet rs = s.executeQuery("SELECT * from tch_data");
    boolean success = false;    // **** Added Code ****

    while(rs.next() && success == false) {
          String userid = rs.getString("user_id");
          String pass = rs.getString("password");

          if(user_id.equals(userid) && cur_pass.equals(pass)) {
              Statement s1 = c.createStatement();
              s1.executeUpdate("UPDATE tch_data SET password='"+new_pass+"' WHERE user_id='"+user_id+"'");
              success = true;   // **** Added Code ****
              JOptionPane.showMessageDialog(new view.AdminPrivacy(), "Password Succesfully Changed!", null, JOptionPane.INFORMATION_MESSAGE);
              break;  // **** Added Code ****
         }
     }
     // **** Added Code ****
     if (!success) {
         JOptionPane.showMessageDialog(new view.AdminPrivacy(), "Error : Invalid Data.", "Error Message", JOptionPane.ERROR_MESSAGE);
     }   
} catch (Exception e) { e.printStackTrace(); }