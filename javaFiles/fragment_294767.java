@Test
    public void testCreateSomethingReturnSuccessfully() {
        JSONObject something = new JSONObject();
        cust.put("name", "integrationTest");
        cust.put("age", 33);

        given().
            contentType(ContentType.JSON).
            body(something.toString()).post("/someEndpoint").
        then().
            statusCode(200).
        assertThat().
            body("id", greaterThan(0)).
            body("name", equalTo("integrationTest")).
            body("age", equalTo(33));
    }