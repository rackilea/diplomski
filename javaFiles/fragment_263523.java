<bean id="logoutController" class="org.jasig.cas.web.LogoutController"
    p:centralAuthenticationService-ref="centralAuthenticationService"
    p:logoutView="casLogoutView"
    p:warnCookieGenerator-ref="warnCookieGenerator"
    p:ticketGrantingTicketCookieGenerator-ref="ticketGrantingTicketCookieGenerator"
    p:servicesManager-ref="servicesManager"
    p:followServiceRedirects="${cas.logout.followServiceRedirects:false}"/>