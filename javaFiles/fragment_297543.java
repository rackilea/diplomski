protected User profileToUser(Profile profile) {
    if ( profile == null ) {
        return null;
    }

    User user = new User();
    User.setId(profile.getUserId());
    return user;
}