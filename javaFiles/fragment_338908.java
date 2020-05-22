if (LoginService.getInstance().validate(mail, password)) {
    final HttpSession session = request.getSession();
    final User user = UserService.getInstance().getUser(mail);
    session.setAttribute("user", user);
    forward = SUCCESS;
}