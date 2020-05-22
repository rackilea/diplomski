public User login(String username, String password) {  
    User user = userDAO.fetchUserByName(username);
    if (!BCrypt.checkpw(password, user.getHash()) 
        throw new AuthenticationException("Failure in authentication");
    return user;
}