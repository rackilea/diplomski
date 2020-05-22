User user = userDAO.find(username, password);
if (user != null) {
    request.getSession().setAttribute("user", user);
    // Display home page.
} else {
    // Display login form with error message.
}