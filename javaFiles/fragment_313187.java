@Inject
Instance<UsernamePasswordCredentials> credInst;

public UserNamePasswordCredentials getCredentials() {
  return credInst.select(UsernamePasswordCredentials.class).get();
}