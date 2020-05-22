<% User user = (User) request.getSession().getAttribute("user"); %>
<ul> 
    <li>Id: <%=user.getId()%></li>

    <li>Name: <%=user.getName()%></li>

    <li>Login: <%=user.getLogin()%></li>

    <li>Email: <%=user.getEmail()%></li>

    <li>Create date: <%=user.getCreateAccount()%></li>

</ul><br/>

<a href="index.jsp">menu</a>