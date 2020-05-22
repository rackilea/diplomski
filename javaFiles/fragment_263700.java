if(entry != null && subNum.equals(1) && rs.getRow() == 1)
 {
         String blogID = rs.getString(1);
         String timeStamp = rs.getString(2);
         java.util.Date date= new java.util.Date();
         String tStamp = new Timestamp(date.getTime()).toString();
         query = "INSERT INTO blog_entries VALUES (?, ?, ?, ?, ?)";
         try{
                if (con != null)
                {
                     ps = con.prepareStatement(query);
                     ps.setString(1, entry);
                     out.print(entry);
                     ps.setString(2, timeStamp);
                     out.print(timeStamp);
                     ps.setString(3, tStamp);
                     out.print(tStamp);
                     ps.setString(4, entry);
                     out.print(entry);
                     ps.setString(5, blogID);
                     out.print(blogID);
                     ps.executeUpdate();
                } else { 
                     // print error and break }                    
            }
      catch (Exception e){
         //print error message
     }
         out.println("Submit Successful");
 }