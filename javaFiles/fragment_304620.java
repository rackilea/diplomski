String data = "{\"scenario\":{\"title\":\"User1_PrivatePrint_1Pg_Duplex_BW_A4\",\"description\":\"Private Print 1 Page Duplex B/W A4 Job\",\"sequences\":[{\"spiMethod\":\"notifyAuthenticationStatus\",\"parameter\":{\"AuthenticationStatus\":{\"AuthenticationState\":\"Authenticated\",\"AuthenticationAttributes\":{\"UserAttributes\":{\"UserId\":\"user1\",\"CustomAttribute\":\"Role1\",\"UserType\":\"Co\"}}}}},{\"spiMethod\":\"validateJobCreation\",\"parameter\":{\"JobCreationConditions\":{\"JobAttributes\":{\"StoredDocumentAttributes\":{\"UserJobType\":\"PrivateSpool\"},\"UserJobType\":\"PrivatePrint\",\"JobAttributesInPrinting\":{\"ColorMode\":\"BW\"}}}}}]}}";

Gson gson = new GsonBuilder().setPrettyPrinting().create();
JsonParser parser = new JsonParser();

JsonElement element = parser.parse(data);
String formattedJSon = gson.toJson(element);
System.out.println(formattedJSon);