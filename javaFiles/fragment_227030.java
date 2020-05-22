@Then("^I expose a HTTP-Rest service to validate the user name and password$")
public void exposeHttpRestService() {
    runner.http(http -> http.server(userServer)
        .receive()
        .post()
        .payload("{\"username\": \"test\", \"password\": \"secret\"}"));

    runner.http(http -> http.server(userServer)
        .send()
        .response(HttpStatus.OK));
}