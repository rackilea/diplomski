String methodName="multiply";
double[] operands = {1,-2.5,0};
double result = operands[0] * operands[1] * operands[2];
Response response = given().
        config(RestAssured.config().jsonConfig(jsonConfig().numberReturnType(BIG_DECIMAL))).
        pathParam("a",operands[0]).
        pathParam("b",operands[1]).
        pathParam("c",operands[2]).
        contentType(JSON).
        log().ifValidationFails().
    when().
        get("/"+methodName+"/{a}/{b}/{c}").
    then().
        assertThat().statusCode(200).
        log().ifValidationFails().
        body("result",closeTo(BigDecimal.valueOf(result),new BigDecimal("1E-20")));