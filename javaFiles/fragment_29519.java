<%
    ArrayList<> list=(ArrayList<>)session.getAttribute("backendresponse");


    %>
<html>
<head>
</head>
<body>
  <%for(int i=0;i<list.size();i++)
    {%>
       <h1> <%=list.get(i).getData() %></h1>
    <%}%>
</body>
</html>