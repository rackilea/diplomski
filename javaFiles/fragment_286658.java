user = userDetails.getByUsername(username);

request.getSession().setAttribute("uname", user);

<%

User user = (User) request.getSession().getAttribute("uname");
if (user.getName() != null) {
response.sendRedirect("home.jsp");
}

%>