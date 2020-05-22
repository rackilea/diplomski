// propagate the security subject from CXF security context
    SecurityContext securityContext = cxfMessage.get(SecurityContext.class);
    if (securityContext != null && securityContext.getUserPrincipal() != null) {
        Subject subject = new Subject();
        subject.getPrincipals().add(securityContext.getUserPrincipal());
        camelExchange.getIn().getHeaders().put(Exchange.AUTHENTICATION, subject);
    }