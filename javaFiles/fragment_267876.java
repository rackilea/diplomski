Keycloak keycloak = Keycloak.getInstance("http://localhost:8080/auth", 
            "master", 
            "admin", 
            "admin", 
            "admin-cli", 
            "password");

UserRepresentation user = new UserRepresentation();
user.setUsername("username1");
user.setFirstName("John");
user.setLastName("Doe");
user.setEnabled(true);
Response response = keycloak.realm("master").users().create(user);