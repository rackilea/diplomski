<% 
   ResultSet resultset=null;
   int i=0;
   int total = 0;
   for(String st:s)
   {
      resultset = statement.executeQuery("select cost from service where name='" + st +"'");
      while(resultset.next())
      { 
         i=resultset.getInt("cost");
         total=total+i;
         out.println(i); 
       }
   }
   out.println(total); 

 %>