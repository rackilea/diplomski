String username = request.getParameter("username");
String password = request.getParameter("password");
User user = new User();
user.setUsername(username);
user.setPassword(password);
user.setFirstName(request.getParameter("firstname"));
user.setLastName(request.getParameter("lastname"));
user.setEmail(request.getParameter("email"));

// ... register the user, then if everything is OK, do:

String url = request.getContextPath() + "/j_security_check";
response.sendRedirect(url + "?j_username="
        + URLEncoder.encode(username, "UTF-8")
        + "&j_password="
        + URLEncoder.encode(password, "UTF-8"));