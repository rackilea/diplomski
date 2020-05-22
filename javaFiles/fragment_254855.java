<% 
       Boolean adminClick = (Boolean) request.getSession().getAttribute("codigosdecargo");

       if(adminClick == false){
    %>
       <label>
          <a href=Rechaza.jsp?hecho=<%=resul.getString("idCalendario") %> >Hecho </a>
       </label>
    <%}
       else{
    %>
       <label>
          <a href=Rechaza.jsp?hecho=<%=resul.getString("idCalendario") %> > Other option </a>
       </label>

   <%}%>