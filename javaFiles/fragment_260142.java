@Override
void sessionDestroyed(HttpSessionEvent se) {
    HttpSession session = se.getSession();
    SecurityContext context = (SecurityContext) session.getAttribute
        (HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
    Authentication authentication = context.getAuthentication();
    // drill down from here, but could be authentication.getName()
}