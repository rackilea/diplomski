@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  User user = repo.findOneByUserName(username);

  if(user == null) {
    throw new UsernameNotFoundException(username);
  }

  List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole());
  return new org.springframework.security.core.userdetails.User(
    user.getUserName(),
    user.getPassword(),
    requireActivation && !user.getToken().equals("1"), // enabled. Use whatever condition you like
    true, // accountNonExpired. Use whatever condition you like
    true, // credentialsNonExpired. Use whatever condition you like
    true, // accountNonLocked. Use whatever condition you like
    auth);
}