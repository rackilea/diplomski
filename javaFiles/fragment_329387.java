public User getUser(Principal principal){
  String userName = principal.getName();
  User user = UsersRepository.loadUser(userName);
  //....
  return user;
}