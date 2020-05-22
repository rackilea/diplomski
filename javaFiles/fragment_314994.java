User user = userService.find(username, password);

if (user != null) {
    request.getSession().setAttribute("user", user);
    response.sendRedirect("home");
} else {
    request.setAttribute("message", "Unknown login, please try again");
    request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
}