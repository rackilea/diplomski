@Test
  public void testBundle() throws Exception {
    RestAssured.when()
      .get("v1/bundles/{bundleId}", TEST_BUNDLE_ID)
    .then()
      .statusCode(HttpStatus.OK.value())
      .body("data.id", equalTo(TEST_BUNDLE_ID))
      .body("errorCode", nullValue());
  }