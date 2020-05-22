try {
  this.userManagement.update(this.username, this.resetPassword, this.resetOldPassword);

} catch(InvalidPasswordException e) {
  super.addMessage(FacesMessage.SEVERITY_ERROR, super.getResource("password.error"), super.getResource("user.password.change.error"));
} catch(UsernameException e) {
  super.addMessage(FacesMessage.SEVERITY_ERROR, super.getResource("username.error"), super.getResource("user.name.error"));
} catch(BlockedAccoutException e) {
  super.addMessage(FacesMessage.SEVERITY_ERROR, super.getResource("blockaccount.error"), super.getResource(blockaccount.error"));
}