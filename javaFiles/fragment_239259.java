private boolean authenticate() {
    if (usernameField.getText().length() == 0
            || passwordField.getPassword().length == 0) {
        errorLabel.setText("Error! Please fill in the required fields.");
        errorLabel.setVisible(true);
    } else {          
        Connection connection = null;    // for establishing a connection to the database
        Statement statement = null;     // for querying the database
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:Login.db");
            //Established Connection
            statement = connection.createStatement();
            // query to be executed
            String sqlQuery = "select * from login where username = '"
                    + usernameField.getText() + "'";
            // result of the executed query
            ResultSet queryResult = statement.executeQuery(sqlQuery);
            String databasePassword = null;       
            // Storing the password from the database
            if (queryResult.next()) {
                databasePassword = queryResult.getString("userpass");
            }
            String enteredPassword = new String(passwordField.getPassword()); 
            // Storing the entered password from the form
            if (enteredPassword.equals(databasePassword)) {
                return true;
                // User is now authenticated and you may enter your redirecting page code here
            } else {
                errorLabel.setText("Invalid username or password. Try again.");
                errorLabel.setVisible(true);
            }
            statement.close();
            connection.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getSimpleName() + " : " + e.getMessage());
            System.exit(0);
        }
    }
    return false;
}