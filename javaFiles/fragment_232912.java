@Test
    public void verifyJSONArrayResponse() {
        JsonArray jsonArray = new JsonArray();

        jsonArray = given().baseUri("http://<your host>")
                .basePath("<your path>")
                .get().as(JsonArray.class);

        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            System.out.println(jsonObject.get("id").getAsString());
        }
    }