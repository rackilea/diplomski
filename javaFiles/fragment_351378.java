public boolean validate(String username, String password) {
    if (!password.equals(this.password))
        return false;
    if (!username.equals(this.username))
        return false;
    return true;
}