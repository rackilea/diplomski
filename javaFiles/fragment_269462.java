@GetMapping

    public String testForCommittee(org.springframework.security.oauth2.provider.OAuth2Authentication principal) {
        Collection<GrantedAuthority> authorities = principal.getAuthorities();
        //since you have all the authorities you can switch method call depending on the authorities

        if(authorities.contains(new SimpleGrantedAuthority("COMMITTEE"))){
          //user has COMMITEE authority.
        }else if{
          // check more
         }
        return "This is a test. Custom result for committee.";
    }