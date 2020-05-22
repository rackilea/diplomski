@Override
@Transactional(propagation = Propagation.REQUIRES_NEW)
public User createUser(User newUser) {
    String username = newUser.getUsername();
    String email = newUser.getEmail();

    if ((username != null) && (userDAO.getUserByUsername(username) != null)) {
        throw new EntityAlreadyExistsException("User already registered: " + username);
    }

    if (userDAO.getUserByUsername(newUser.getEmail()) != null) {
        throw new EntityAlreadyExistsException("User already registered: " + email);
    }

    return userDAO.merge(newUser);
}

@Override
@Transactional(propagation = Propagation.REQUIRES_NEW)
public User processNewRegistration(
        User newUser,
        Boolean waitForAccount) 
{
    Future<UserAccount> customer = paymentService.initializeForNewUser(newUser);
    if (waitForAccount) {
        try {
            customer.get();
        } catch (Exception e) {
            logger.error("Error while creating Customer object!", e);
        }
    }

    // Do some other maintenance type things...

    return newUser;
}