public void validate() {
    boolean tryLogin = true;

    if (isBlank(username)) {
        addFieldError("username", getText("login.username.required"));
        tryLogin = false;
    }

    if (isBlank(password)) {
        addFieldError("password", getText("login.password.required"));
        tryLogin = false;
    }

    if (tryLogin && !userService.loginValid(username, password)) {
        addActionError(getText("login.failure"));
    }
}