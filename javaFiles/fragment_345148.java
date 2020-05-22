public final class UrlAuthorization {
    private static final Logger LOG = LoggerFactory.getLogger(UrlAuthorization.class);

    private final FilterInvocationSecurityMetadataSource securityMetadataSource;
    private final AccessDecisionManager accessDecisionManager;

    public UrlAuthorization(FilterInvocationSecurityMetadataSource securityMetadataSource,
                            AccessDecisionManager accessDecisionManager) {

        this.securityMetadataSource = securityMetadataSource;
        this.accessDecisionManager = accessDecisionManager;
    }

    public boolean isAccessible(String url) {
        Authentication authentication = AuthUtils.getAuthentication();

        FilterInvocation invocation = new FilterInvocation(null, url, HttpMethod.GET.name());
        Collection<ConfigAttribute> attributes = securityMetadataSource
                .getAttributes(invocation);

        try {
            this.accessDecisionManager.decide(authentication, invocation, attributes);

        } catch (AccessDeniedException e) {
            LOG.trace("Not allowed to access URL: {}", url, e);
            return false;
        }
        return true;
    }
}