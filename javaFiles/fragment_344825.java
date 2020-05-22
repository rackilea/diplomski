Principal userPrincipal = request.getUserPrincipal();

if (userPrincipal != null) {   
    httpMessageContext.getHandler().handle(new Callback[] { 
                new CallerPrincipalCallback(httpMessageContext.getClientSubject(), userPrincipal) }
            );

    return AuthenticationStatus.SUCCESS; 
}