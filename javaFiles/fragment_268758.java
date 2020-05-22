public static Response validateXmlResponse() throws IOException {
         // Navigate to xml file path attached in project
         String FilePath = "c\downloads\filepath;
         String XMLBodyToPost = new String(Files.readAllBytes(Paths.get(FilePath)));

         // Call the baseUrl to test the request
         RestAssured.baseURI = TestURL;

         // Getting a reponse for submitted POST request
         Response res = given().auth().basic(userName, password).body(XMLBodyToPost).
                      when().post()
                      .then()
                .statusCode(200).and().contentType(ContentType.HTML).extract().response();
         String response = res.asString();
         // System.out.println("Returning response as string format:" + " " + response);

         return res;
   }