public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

@Override
protected String determineTargetUrl(HttpServletRequest request, HttpServletResponse response) {

    String targetUrl = null;

    SecurityContext securityContext = SecurityContextHolder.getContext();

    Collection<GrantedAuthority> authorities = securityContext.getAuthentication().getAuthorities();

    if (authorities.contains(new GrantedAuthorityImpl("ROLE_NEEDS_EMAIL_AUTH"))) {
        targetUrl = "/authenticate";
    } else if (authorities.contains(new GrantedAuthorityImpl("ROLE_AUTHORIZED_USER"))) {
        targetUrl = "/authorized_user_url";
    } else {
        targetUrl = super.determineTargetUrl(request, response);
    }

    return targetUrl;
}