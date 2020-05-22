UserLogin { // just fields that are needed to login, not a User business object
    String name;
    String password;
}

LoginService { // sample sarvice that check passwords
    boolean Login(UserLogin userLogin) {...}
}