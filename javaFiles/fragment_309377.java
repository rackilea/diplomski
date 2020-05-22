while(rs.next()){
   String name = rs.getString("Namet");
   //rs.getString returns Ayaan. So value of name is "Ayaan"
   nameofguy.setText(rs.getString(name));
   // Youre trying to get the value corresponding to the column Ayaan here
   //This is why the exception is thrown as there is no column called Ayaan
   }