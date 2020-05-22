ResultSet rset=select.SelectAll(username,password);
if (rset.next()){
  User user = new User();
  user.setUsername(rset.get("username"));
  user.setEmail(rset.get("email"));
  user.setContact(rset.get("contact"));
  request.setAttribute("user",user);
  getServletContext().getRequestDispatcher("/dashboard.jsp")
                    .forward(request,response);
}