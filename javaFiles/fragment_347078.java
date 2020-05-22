try {

    Algorithm algorithm = Algorithm.HMAC256("secret");
    Date expirationDate = Date.from(ZonedDateTime.now().plusMinutes(60).toInstant());
    String token = JWT.create()
                      .withExpiresAt(expirationDate)
                      .withClaim("username", username)
                      .sign(algorithm);

} catch (UnsupportedEncodingException e){
    // UTF-8 encoding not supported
} catch (JWTCreationException e){
    // Invalid signing configuration / Couldn't convert claims
}