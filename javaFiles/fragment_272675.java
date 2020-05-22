public class LoginLogoutAPI {

    private static final LoginLogoutAPI INSTANCE = new LoginLogoutAPI();
    private static final String LOGIN_ENDPOINT = "/auth/login";

    public static LoginLogoutAPI getInstance() {
        return INSTANCE;
    }

    public ValidatableResponse postLogin(String login, String password) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<byte[]> httpEntity = new HttpEntity<byte[]>(headers);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(LOGIN_ENDPOINT)
                                                           .queryParam("login",login)
                                                           .queryParam("password",password);
        URI uri=builder.buildAndExpand().toUri();
        ResponseEntity<ValidatableResponse> rs = restTemplate.exchange(uri, HttpMethod.POST, httpEntity,ValidatableResponse.class);
        return rs.getBody();
    }
}