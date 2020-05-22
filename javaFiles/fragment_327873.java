Public List<Claim> validateAuthenticationResponse(String yourToken){
    SamlTokenValidator validator = new SamlTokenValidator();

    validator.setThumbprint("thumbprint from the thinktecture idp server or what ever idp you are using");

    validator.getAudienceUris().add(new URI(“http://localhost:8080/javafederationtest”);

    //validator.setValidateExpiration(false); //This can be used to stop validation of the expiration fields in the token.

    List<Claim> claims = validator.validate(yourToken); //A Federation Exception is thrown if the token is invalid

    System.out.println(claims.toString()); //This will show the claims asserted by the token!
}