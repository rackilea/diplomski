@Test (priority=1, dependsOnMethods = {"checkIfAllServicesAreUp"})
public void verifyCreateUser() {
    RestAssured.baseURI = "someValidURI";
    RequestSpecification spec = new RequestSpecBuilder().setBasePath("userservice/user/").setContentType(ContentType.JSON).log(LogDetail.METHOD).build();
    response = RestAssured.given().spec(spec).headers("source","APP").body("{ }").when().post("");
}