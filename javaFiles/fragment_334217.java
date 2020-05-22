@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
  User user = repo.findOneByUserName(username);

  if(user == null) {
    throw new UsernameNotFoundException(username);
  }

  return user;
}