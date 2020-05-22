<%if(request.getAttribute("fname")!=null){%>
    <input type="text" value ="<%=request.getAttribute("fname") %>"/>
    <%}else
    { %>
    <input type="text"/>
    <%} %>