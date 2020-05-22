<% String s=request.getParameter("status");
         If (s==null)
          {  }
         else if (s.equals ("1"))
         {
    %>
   <br/><h3>  user id already exist </h3>
    <%} 
         else if (s.equals ("2"))
         {
    %>
   <br/><h3> registration successfull</h3>
    <%}
         else { }%>