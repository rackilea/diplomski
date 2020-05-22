public boolean verifyLibrarian() {
    for (User s : users) {
    //if just one of my objects is librarian it will return true.
        if (s.getUserType() == User.enumUserType.LIBRARIAN) {
            return true;
        }    
    }
    throw new IllegalArgumentException("Username or password is incorrect");
}