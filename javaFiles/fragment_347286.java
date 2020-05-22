static class IgnoreFailuresBasicAuthenticationFilter extends BasicAuthenticationFilter {
    private final BasicAuthenticationFilter everythingElse;

    public IgnoreFailuresBasicAuthenticationFilter(BasicAuthenticationFilter everythingElse) {
        super(everythingElse.getAuthenticationManager());
        this.everythingElse = everythingElse;
    }

    protected void doFilterInternal(request, response, chain) {
        if ("/api/v1/notification".equals(request.getPathInfo())) {
            super.doFilterInternal(request, response, chain);
        } else {
            this.everythingElse.doFilterInternal(request, response, chain);
        }
    }
}