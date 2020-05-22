java.util.Base64.Encoder encoder = java.util.Base64.getUrlEncoder();
    String codeChallenge = // get code challenge from my cache;
    String encodedVerifier = new String(encoder.encode(sha256(codeVerifier))).split("=")[0]; // Remember to remove padding
    if (!encodedVerifier.equals(codeChallenge)) {
        return Response.status(400).entity(ERROR_INVALID_CHALLENGE_VERIFIER).build();
    }