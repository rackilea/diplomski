private static final int PORT = 1922;
private static String getEndpoint;
private static String postEndpointURI;

/**
 * First part of the building up the request
 */
private static RequestSpecification buildRequest() {
    return given()
            .port(PORT)
            .contentType(ContentType.JSON)
            .when()
            .log().all();
}

/**
 * Relevant part of the GET request
 */
private static Response buildGetRequest() {
    return buildRequest().get(getEndpoint);
}

/**
 * Relevant part of the POST request
 */
private static Response buildPostRequest(Request request) {
    return buildRequest().body(request).post(postEndpointURI);
}

/**
 * Last bit redundant that was called by both calls
 */
private static Response extractResponse(Response response, int expectedStatusCode) {
    return response.then()
            .log().all()
            .assertThat()
            .statusCode(expectedStatusCode).extract().response();
}


/**
 * Your main GET method
 */
public static Response assertThatGetResponseStatusIs(int expectedStatusCode) {
    return extractResponse(buildGetRequest(), expectedStatusCode);
}

/**
 * Your main POST method
 */
public static Response assertThatPostResponseStatusIs(Request request, int expectedStatusCode) {
    return extractResponse(buildPostRequest(request), expectedStatusCode);
}

public static void main(String[] args) {
    System.out.println(assertThatGetResponseStatusIs(500));
    System.out.println(assertThatPostResponseStatusIs(request, 400));
}