UserInfo ui = new UserInfo();

DirectoryUser du = null;
try {
    du = LDAPService.findUser(username);
} catch (NullPointerException npe) {
    // It's fine if findUser throws a NPE
}
if (du != null) {
   ui.setUserInfo(du.getUserInfo());
}