Authentication auth = new UsernamePasswordAuthenticationToken(userName.getValue(),password.getValue());
Authentication authenticated = daoAuthenticationProvider.authenticate(auth);
            SecurityContextHolder.getContext().setAuthentication(authenticated);

//redirect to main application
getPage().setLocation("/main");