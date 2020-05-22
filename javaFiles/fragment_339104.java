public void hitEndpoint(String endpoint) {
            DataStore dataStore = DataStoreFactory.getScenarioDataStore();
            HttpResponse<JsonNode> httpResponse;
            String url = "xxx/xxx"t;
            try {
                httpResponse = Unirest.post(url)
                        .asJson();
                dataStore.put("httpResponse", httpResponse);
    ...
}