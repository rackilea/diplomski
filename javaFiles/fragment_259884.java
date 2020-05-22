http.csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
    private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
    private RegexRequestMatcher apiMatcher = new RegexRequestMatcher("/v[0-9]*/.*", null);

    @Override
    public boolean matches(HttpServletRequest request) {
        // No CSRF due to allowedMethod
        if(allowedMethods.matcher(request.getMethod()).matches())
            return false;

        // No CSRF due to api call
        if(apiMatcher.matches(request))
            return false;

        // CSRF for everything else that is not an API call or an allowedMethod
        return true;
    }
});