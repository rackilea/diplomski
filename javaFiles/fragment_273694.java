class user extends TextGame {
    String username;
    int password;
    String[] notes;

    public user(String username, int password) {
        this.username=username;
        this.password=password;
    }

    public void login(int password) {
        this.password=password;
        System.out.println("please type the password to proceed.");
        if (scan.nextLine().equals(this.password)) {
            System.out.println("logged in. type 'note' to access notes, or 'logoff' to log off this user.");
        }
    }

}