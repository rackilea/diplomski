protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException {
        try {
            String authenticationKey = ExternalAuthentication.startExternalAuthentication(request);

            // get userPrincipalName of previous authn
            final ProfileRequestContext profileRequestContext = ExternalAuthentication.getProfileRequestContext(authenticationKey, request);
            final SubjectCanonicalizationContext c14nContext = profileRequestContext.getSubcontext(SubjectCanonicalizationContext.class);
            if (c14nContext != null && c14nContext.getPrincipalName() != null) {
                usernameShib = c14nContext.getPrincipalName();
                //Subject subjectShib = c14nContext.getSubject();
                logger.info(usernameShib);
            }
        //...
}