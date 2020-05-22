public void authenticate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    List <String> scopes = new LinkedList<String>();
    scopes.add(scope);
    AuthorizationCodeRequestUrl authorize = new GoogleAuthorizationCodeRequestUrl(client_id, redirect_uri, scopes);
    authorize.setRedirectUri(redirect_uri);
    String authorize_url              = authorize.build();
    log.info(authorize_url);
    response.sendRedirect(authorize_url);
}