public String userWithName(String s) {
    String username = null;
    for(User u: listofusers) {
        if(u.getUsername().equals(s)) {
            username = s;
        }
    }
    return username;
}