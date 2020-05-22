protected void automatedLogin(String username, String password, HttpServletRequest request) {

        try {
            // Must be called from request filtered by Spring Security, otherwise SecurityContextHolder is not updated
            CustomUserDetailsService udService = new CustomUserDetailsService(userDAO, request);
            CustomMd5PasswordEncoder passEncoder = new CustomMd5PasswordEncoder();
            ReflectionSaltSource saltSource = new ReflectionSaltSource();
            saltSource.setUserPropertyToUse("salt");
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            token.setDetails(new WebAuthenticationDetails(request));
            DaoAuthenticationProvider authenticator = new DaoAuthenticationProvider();
            authenticator.setUserDetailsService(udService);
            authenticator.setPasswordEncoder(passEncoder);
            authenticator.setSaltSource(saltSource);
            Authentication authentication = authenticator.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        } catch (Exception e) {
            e.printStackTrace();
            SecurityContextHolder.getContext().setAuthentication(null);
        }

    }