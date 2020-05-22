Authenticator.setDefault(new Authenticator() {
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(
            USER_NAME,
            PASSWORD.toCharArray());
    }
});