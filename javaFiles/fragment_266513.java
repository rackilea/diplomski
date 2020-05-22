public UserResource(UserService userService, UserRepository userRepository, MailService mailService, ExtendedUserService extendedUserService) {
    this.userService = userService;
    this.userRepository = userRepository;
    this.mailService = mailService;
    this.extendedUserService = extendedUserService;
}