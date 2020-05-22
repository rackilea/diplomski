<% // in Title.jsp
  request.setAttribute ("user", new User());
%>

<% // in Header.jsp
  User user = request.getAttribute ("user");
  user.setName ("John Doe");
%>