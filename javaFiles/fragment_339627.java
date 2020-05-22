@Override
public User registerUserWithProfileData(User newUser, String password, Boolean waitForAccount) {
    newUser.setPassword(password);
    newUser.encodePassword();
    newUser.setJoinDate(Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTime());

    User registered = userService.createUser(newUser);
    registered = userService.processNewRegistration(registered, waitForAccount);

    return userService.setProfileInformation(registered);
}