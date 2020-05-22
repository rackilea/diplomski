public static boolean validateUsernameAndPassword(String username, String password) {
    int index = UsernameList.indexOf(username);
    if (index == -1) { 
        System.out.println("The user name does not exist");
        return false; 
    }
    String correctPassword = PasswordList.get(index);
    if (correctPassword.equals(password)) {
        return true;
    } else {
        System.out.println("Please input again your password");
        return false;
    }
}