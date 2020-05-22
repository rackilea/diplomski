Authenticator.setDefault(new Authenticator() {
  protected PasswordAuthentication getPasswordAuthentication() {
    if("stackoverflow.com".equals(getRequestingHost()) {
      return new PasswordAuthentication("user", "p@ss".toCharArray());
    } else {
      return null;
    }
  }
});