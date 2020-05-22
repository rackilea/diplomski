User user = ofy().transact(new Work<User>() {
    @Override
    public User run()
    {
        User_Name name = ofy().load().key(Key.create(User_Name.class, data.username)).now();
        if (name != null)
            return null;

        User_Email email = ofy().load().key(Key.create(User_Email.class, data.email)).now();
        if (email != null)
            return null;

        name = new User_Name(data.username);
        email = new User_Email(data.email);

        ofy().save().entity(name).now();
        ofy().save().entity(email).now();

        // only if email and name is unique create the user

        User user = new User();
        user.name = data.username;
        user.email = data.email;
        // fill other properties...

        ofy().save().entity(user).now();

        return user;
    }
});