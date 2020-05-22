@Inject
protected PasswordEncryption passwordEncryption;

...

user.setPassword(passwordEncryption.getPasswordHash(user.getId(), password));