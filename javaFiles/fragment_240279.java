...
@Context
SecurityContext securityContext;
...
allowOnlyAdmin(securityContext);
...
public void allowOnlyAdmin(SecurityContext securityContext) {
  if (securityContext.getAuthenticationScheme() != null
    && !securityContext.isUserInRole(AuthorizationRoleEnum.ADMIN.toString())) {
    throw new WebApplicationException(Response.status(Response.Status.FORBIDDEN)
      .entity("User does not have required " + AuthorizationRoleEnum.ADMIN + " role!").build());
  }
}
...