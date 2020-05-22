UserService userService = UserServiceFactory.getUserService();
User user = userService.getCurrentUser();

if (user != null) {
    String email = user.getEmail();
} else {
    // no user logged in
}