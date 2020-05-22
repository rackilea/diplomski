String query = "select ID,FirstName,LastName,Dept from student where ";
   String delim = "";
   if(firstName != null){
      query+ = delim + "FirstName = '"+firstName+"'";
      delim = " AND ";
   }
   if(lastName != null){
      query+ = delim + "LastName = '"+lastName +"'";
      delim = " AND ";
   }
   .........
   .........
   PreparedStatement pre = conn.prepareStatement(query);