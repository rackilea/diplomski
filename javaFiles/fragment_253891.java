@Bean(name = "passwordEncoder")
    public BCryptPasswordEncoder getPasswordEncoder() {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(BCryptVersion.$2B);
        return bCryptPasswordEncoder;

    }