@Test
@WithMockUser(roles = "TEST")
public void name() throws Exception {
    given()
            .auth().basic("testuser", "password") // ######
            .port(port)
        .when()
            .get("/")
        .then()
            .statusCode(HttpStatus.OK.value());
}