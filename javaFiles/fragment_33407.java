@Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario account = accountDao.findByUsername(username);

        if(account == null) {
            throw new UsernameNotFoundException("No such user: " + username);
        }

        List<Autorizacoes> auth = account.getAutorizacoes();

        if(auth.isEmpty()) {
            throw new UsernameNotFoundException("User " + username + " has no authorities");
        }

        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        boolean accountEnabled = true;

        return new User(account.getLogin(), account.getSenha(), accountEnabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(account.getAutorizacoes()));
    }