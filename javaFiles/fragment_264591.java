class AuthorizationFilter implement ContainerRequestContext {
    @Context
    private ResourceInfo info;

    @Override
    public void filter(ContainerRequestContext request) {
        SecurityContext sc = request.getSecurityContext();
        RolesAllowed anno = info.getResourceMethod().getAnnotation(RolesAllowed.class);
        String rolesAllowed = anno.value();
        for (role: rolesAllowed) {
            if (sc.isUserInRole(role)) {
                 return;
            }
        }
        request.abortWith(Response.status(403).build());
    }
}