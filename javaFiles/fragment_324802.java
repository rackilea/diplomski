/**
 * Get the subscription bean
 * @return the subscriptionService
 */
public ISubscriptionService getSubscriptionService(ServletContext servletContext) {
    ApplicationContext ctx = WebApplicationContextUtils
            .getWebApplicationContext(servletContext);
    return ctx.getBean("subscriptionService", ISubscriptionService.class);
}