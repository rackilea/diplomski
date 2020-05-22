try {

    Algorithm algorithm = Algorithm.HMAC256("secret");
    JWTVerifier verifier = JWT.require(algorithm).build();
    DecodedJWT jwt = verifier.verify(token);

    Claim usernameClaim = jwt.getClaim("username");
    String username = usernameClaim.asString();

} catch (UnsupportedEncodingException e){
    // UTF-8 encoding not supported
} catch (JWTVerificationException e){
    // Invalid signature/claims
}