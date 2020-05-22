public static void main(String[] args) {
    greeting();
    questiona();
    questionb();
    username();
    password();
    boolean usernamecheck = checkOne(validusername, inputusername);
    boolean passwordcheck = checkTwo(validpassword, inputpassword);
    checkFinal(usernamecheck, passwordcheck);
}