import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

// skipping class definition here, just showing the method call

private void optionsCall() {
    final String url = "https://some.server/with/some/path";
    final String user = "theUser";
    final String password = "thePassword";

    final String authHeaderValue = "Basic " + Base64.getEncoder()
            .encodeToString((user + ':' + password).getBytes());

    final HttpHeaders requestHeaders = new HttpHeaders();
    requestHeaders.set("Authorization", authHeaderValue);

    RestTemplate rest = new RestTemplate();
    final ResponseEntity<Object> optionsResponse =
            rest.exchange(url, HttpMethod.OPTIONS,
                    new HttpEntity<>(requestHeaders),
                    Object.class);

    optionsResponse.getHeaders().forEach((key, value) -> log.info("{} -> {}", key, value));
}