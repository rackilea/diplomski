@Override
public Authentication authenticate(Authentication authentication) throws AuthenticationException {
  UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken) authentication;
  String username = String.valueOf(auth.getPrincipal());
  String password = String.valueOf(auth.getCredentials());

  logger.info("username:" + username);
  logger.info("password:" + password); // Don't log passwords in real app

  // 1. Use the username to load the data for the user, including authorities and password.
  YourUser user = ....

  // 2. Check the passwords match (should use a hashed password here).
  if (!user.getPassword().equals(password)) {
    throw new BadCredentialsException("Bad Credentials");
  }

  // 3. Preferably clear the password in the user object before storing in authentication object
  user.clearPassword();

  // 4. Return an authenticated token, containing user data and authorities  

  return new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities()) ;
}