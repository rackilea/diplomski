User user = userDAO.find(username, password);

if (user != null) {
    request.getSession().setAttribute("user", user);
    request.getRequestDispatcher("portfolio_one.jsp").forward(request, response);
} else {
    response.sendRedirect("LoginFailure.jsp");
}