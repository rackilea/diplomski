@Override
@Autowired
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
            .userDetailsService(username -> {
                User user = userRepository.findByUsername(username);

                if (user == null) throw new UsernameNotFoundException("Invalid user");

                return user;
            });
}