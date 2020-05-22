public class TokenResponse {

private String access_token;
private String token_type;
private Long expires_in;
private String refresh_token;
private String id_token;

..getters and setters}

public class IdTokenPayload {

private String iss;
private String aud;
private Long exp;
private Long iat;
private String sub;//users unique id
private String at_hash;
private Long auth_time;

..getters and setters}