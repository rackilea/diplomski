try {
    GitHubClient client = new GitHubClient().setCredentials(login, password);
    UserService userService = new UserService(client);
    User user = userService.getUser(login);
    ...
} catch (RequestException re) {
    if (re.getMessage().endsWith("Bad credentials (401)")) {
        // input login/password incorrect...
    } else {
        // some other reason...  
    }
}