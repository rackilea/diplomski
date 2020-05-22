public KeyProfileUserSummary(KeyProfileUser keyProfileUser) {
  this.id = keyProfileUser.getId();
  this.login = keyProfileUser.getLogin();
  this.password = keyProfileUser.getPassword();
  this.firstname = keyProfileUser.getPerson().getFirstname();
  this.lastname = keyProfileUser.getPerson().getLastname();
  this.userRole = keyProfileUser.getUserRole();
}