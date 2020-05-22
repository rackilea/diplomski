return Optional.ofNullable(claims.get().getSubject())
               .map(userDetailsService::loadUserByUsername)
               .map(userDetails -> {
                   UsernamePasswordAuthenticationToken authentication = 
                       new UsernamePasswordAuthenticationToken(
                           userDetails, null, userDetails.getAuthorities());
                   authentication.setDetails(
                       new WebAuthenticationDetailsSource().buildDetails(request));
                   return authentication;
               })
               .orElseThrow(() -> new BadCredentialsException(
                  "The authentication token " + optToken + " did not contain a subject."));