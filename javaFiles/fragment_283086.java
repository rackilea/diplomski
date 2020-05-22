List<Result> resultList = jdbcQuery.query(/* some sql */,
    (rs, arg1) ->{ // RowMapper as Lambda
        User user = new User();
        // assign user properties from rs
        Role role = new Role();
        // assign role properties from rs;
        return new Result(user, role);
    });

// now process your users and roles
resultList.forEach(r -> {
    User user = result.getUser();
    Role role = result.getRole();
    // do something here with User and Role
});