@Override
    @Transactional
    public UserDetails loadUserByUsername(final String login) {
        log.debug("Authenticating {}", login);

        String lowercaseLogin = login.toLowerCase();
//        Optional<User> userFromDatabase =  userRepository.findOneByLogin(login);
        Optional<User> userFromDatabase =  userRepository.findOneByEmail(login);
        return userFromDatabase.map(user -> {
            if (!user.getVerified()) {
                throw new UserNotActivatedException("User " + lowercaseLogin + " was not activated");
            }

            List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                    .map(authority -> new SimpleGrantedAuthority(authority.getName()))
                    .collect(Collectors.toList());
//            return new org.springframework.security.core.userdetails.User(lowercaseLogin,
            return new org.springframework.security.core.userdetails.User(user.getLogin(),
                    user.getPassword(),
                    grantedAuthorities);
        }).orElseThrow(() -> new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database"));
    }