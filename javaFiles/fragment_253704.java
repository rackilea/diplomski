public boolean validateUser(String filename, String name, String password) {
    ...
    if(check(accinfo, name, password)) {
        return true;
    }
    ...
    return false
}