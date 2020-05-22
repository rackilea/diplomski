public void actionPerformed(ActionEvent e) {
    String username = "user";
    String password = "pass";

    List<String> dtbSearchResults;
    try (DatabaseConnection connection = new DatabaseConnection()) {
        dtbSearchResults = connection.search(username, password); 
    } catch (SomeExceptionYouReallyShouldHandle e) {
        // seriously, handle it here
    }

    System.out.println(username);
    System.out.println(password);
    System.out.println(dtbSearchResults.get(0));
    System.out.println(dtbSearchResults.get(1));
    System.out.println(username.equals(dtbSearchResults.get(0)));
    System.out.println(password.equals(dtbSearchResults.get(1)));

    if (username.equals(dtbSearchResults.get(0)) && password.equals(dtbSearchResults.get(1))) {
        System.out.println("Hello, " + username);
    }
}