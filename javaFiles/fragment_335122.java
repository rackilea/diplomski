@WebListener
public class SessionCounterListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        HttpSession session = httpSessionEvent.getSession();
        session.setMaxInactiveInterval(60*15);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {

        HttpSession session = httpSessionEvent.getSession();
        SessionDestroyedEvent sessionDestroyedEvent = new HttpSessionDestroyedEvent(session);
        ApplicationContext ctx =
                WebApplicationContextUtils.
                        getWebApplicationContext(session.getServletContext());
        ContractorService contractorService = (ContractorService) ctx.getBean("contractorService");
        for (SecurityContext securityContext : sessionDestroyedEvent.getSecurityContexts()) {
            Authentication authentication = securityContext.getAuthentication();
            CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        }

    }

}