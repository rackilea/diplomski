public class AppleLoginUtil {
private static String APPLE_AUTH_URL = "https://appleid.apple.com/auth/token";

private static String KEY_ID = "**********";
private static String TEAM_ID = "**********";
private static String CLIENT_ID = "com.your.bundle.id";

private static PrivateKey pKey;

private static PrivateKey getPrivateKey() throws Exception {
//read your key
    String path = new ClassPathResource("apple/AuthKey.p8").getFile().getAbsolutePath();

    final PEMParser pemParser = new PEMParser(new FileReader(path));
    final JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
    final PrivateKeyInfo object = (PrivateKeyInfo) pemParser.readObject();
    final PrivateKey pKey = converter.getPrivateKey(object);

    return pKey;
}

private static String generateJWT() throws Exception {
    if (pKey == null) {
        pKey = getPrivateKey();
    }

    String token = Jwts.builder()
            .setHeaderParam(JwsHeader.KEY_ID, KEY_ID)
            .setIssuer(TEAM_ID)
            .setAudience("https://appleid.apple.com")
            .setSubject(CLIENT_ID)
            .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 5)))
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .signWith(pKey, SignatureAlgorithm.ES256)
            .compact();

    return token;
}

/*
* Returns unique user id from apple
* */
public static String appleAuth(String authorizationCode) throws Exception {

    String token = generateJWT();

    HttpResponse<String> response = Unirest.post(APPLE_AUTH_URL)
            .header("Content-Type", "application/x-www-form-urlencoded")
            .field("client_id", CLIENT_ID)
            .field("client_secret", token)
            .field("grant_type", "authorization_code")
            .field("code", authorizationCode)
            .asString();

    TokenResponse tokenResponse=new Gson().fromJson(response.getBody(),TokenResponse.class);
    String idToken = tokenResponse.getId_token();
    String payload = idToken.split("\\.")[1];//0 is header we ignore it for now
    String decoded = new String(Decoders.BASE64.decode(payload));

    IdTokenPayload idTokenPayload = new Gson().fromJson(decoded,IdTokenPayload.class);

   return idTokenPayload.getSub();
}


}