UserRepresentation user = new UserRepresentation();
    user.setEmail("naveenm@gmail.com");
    user.setUsername("naveenm555");
    user.setFirstName("naveen");
    user.setLastName("m");
    user.setEnabled(true);
    Response response = kc.realm("appscook").users().create(user);
    System.out.println("user created.... verify in keycloak!");
    String userId = getCreatedId(response);

    UserResource userResource=kc.realm("appscook").users().get(userId);
    CredentialRepresentation newCredential = new CredentialRepresentation();
    newCredential.setType(CredentialRepresentation.PASSWORD);
    newCredential.setValue("naveenm555");
    newCredential.setTemporary(false);
    userResource.resetPassword(newCredential);
    System.out.println("role created.");