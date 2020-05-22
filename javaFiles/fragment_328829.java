String token = given()
                .contentType("application/json")
                .body(new User("someuser" , "123"))
                .when()
                .post(RestConfig.baseUrl+"/authentication-url")
                .then().extract().response().as(TokenResponse.class).getToken();

        given()
                .contentType("application/json")
                .header("Authorization", token)
                .get(RestConfig.baseUrl+"/some-path")
                .then()
                .statusCode(200)...