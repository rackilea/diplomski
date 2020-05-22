provider.setUserDetailsService((s) -> {
        if(!allowedLogin.contains(s.getAssertion().getPrincipal().getName())) {
            throw new UsernameNotFoundException("user not authorized to use app");
        }
        return new User(s, "fakepassword", true, true, true, true, AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
    });