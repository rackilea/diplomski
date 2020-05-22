<%
   if(request.getAttribute("error_message") != null)
    {
      <div id='result' ><%=request.getAttribute("error_message")%></div>
    }
%>