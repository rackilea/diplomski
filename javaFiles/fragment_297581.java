final Authentication result = super.authenticate(auth);

UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getName());

return new UsernamePasswordAuthenticationToken(userDetails, 
        result.getCredentials(), userDetails.getAuthorities());