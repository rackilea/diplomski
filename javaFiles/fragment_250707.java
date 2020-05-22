@Override
public String login(LoginUser user) {
       // valid user if it exits then do the following

        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

       //generate the token and do other process.
}