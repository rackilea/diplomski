<%
//get parameters from the request
String userName = request.getParameter("userName");

user = UserDB.getUsers("userName");
//it should be (with out the quotes
user = UserDB.getUsers(userName);

%>