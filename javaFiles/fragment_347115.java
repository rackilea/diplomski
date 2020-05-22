public void actionPerformed(ActionEvent e) {
    String username = "user";
    String password = "pass";

    UserCredentials user;
    try (DatabaseConnection connection = new DatabaseConnection()) {
        user = connection.search(username, password); 
    } catch (SomeExceptionYouReallyShouldHandle e) {
        // seriously, handle it here
    }

    System.out.println(username);
    System.out.println(password);
    System.out.println(user.getUsername());
    System.out.println(user.getPassword());
    System.out.println(username.equals(user.getUsername()));
    System.out.println(password.equals(user.getPassword()));

    if (username.equals(user.getUsername())
            && password.equals(user.getPassword())) {
        System.out.println("Hello, " + username);
    }
}