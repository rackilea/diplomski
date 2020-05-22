public class BasicAuthenticator implements Authenticator<BasicCredentials, Subject> {

  @Override
  public Optional<Subject> authenticate(BasicCredentials credentials) throws AuthenticationException {
    Subject subject = SecurityUtils.getSubject();
    try {
      subject.login(new UsernamePasswordToken(credentials.getUsername(), credentials.getPassword(), false));
      return Optional.of(subject);
    } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
    } catch (AuthenticationException ae) {
    }
    return Optional.absent();
  }

}