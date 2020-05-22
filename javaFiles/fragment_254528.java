auth.jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery("SELECT USERNAME,SECRET_KEY, ENABLED FROM USERS WHERE USERNAME=?")
        .authoritiesByUsernameQuery(
            "SELECT A.USERNAME, B.ROLE_NAME"
            + " FROM USERS A, ROLES B, USER_ROLES C"
            + " WHERE C.USER_ID = A.USER_ID AND C.ROLE_ID = B.ROLE_ID AND A.USERNAME=?"
        )
        .passwordEncoder(new BCryptPasswordEncoder());