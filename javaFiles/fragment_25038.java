public String login() {
    // ...
    return "home?faces-redirect=true";
}

public String logout() {
    // ...
    return "login?faces-redirect=true";
}