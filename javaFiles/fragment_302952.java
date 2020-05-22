UserService userService = UserServiceFactory.getUserService();
user = userService.getCurrentUser();

if (user == null) {
    res.sendRedirect(userService.createLoginURL(req.getRequestURI()));
    return;
}