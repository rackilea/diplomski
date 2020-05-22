public class EmailServiceImpl {   

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Transactional(rollbackFor = Exception.class)
    public User createUserAndSendEmail(UserDto userDto) throws UserEmailException {
        try {
            User user = userService.create(userDto);

            //Publish UserCreatedEvent such the UserCreatedEventHandler can handled it after TX commit
            applicationContext.publishEvent(new UserCreatedEvent(user));

            return user;
        } catch (Exception exception) {
            throw new UserEmailException(exception.getMessage());
        }
    }
}