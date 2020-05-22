public static boolean validateLogIn(LinkedList<User> users,
        String username, String password) {

    Iterator<User> spin = users.iterator();
    while (spin.hasNext()) {
        User user = spin.next();
        System.out.println("I'm roling");
        if (user.validate(username, password)) {
            System.out.println("BINGO!");
            return userLogedIn = true;
        } else {
            return false;
        }
    }

    return false;
}