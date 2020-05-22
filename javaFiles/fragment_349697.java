public String execute() {
    if (userService.loginValid(username, password) {
        return SUCCESS;
    }

    addActionError(getText("login.failure"));
    return FAILURE;
}