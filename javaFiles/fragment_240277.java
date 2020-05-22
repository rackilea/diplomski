...
application.setRoles(getRoles(application));
... 
public static List<Role> getRoles(JaxRsApplication application) {
  List<Role> roles = new ArrayList<>();
  for (AuthorizationRoleEnum authorizationRole : AuthorizationRoleEnum.values()) {
      roles.add(new Role(application, authorizationRole.toString()));
  }
  return roles;
}
...