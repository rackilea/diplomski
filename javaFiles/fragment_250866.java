JSONObject responseObject = new JSONObject(responseFromService.getResponseBody())
      .getJSONObject("RESPONSE");

ObjectMapper objectMapper = new ObjectMapper();
Map<String, SummaryObject> summaryMap = objectMapper.readValue(responseObject.toString(), new TypeReference<Map<String, SummaryObject>>() {});
SomeResponseObject response = new SomeResponseObject();
response.setSummaryMap(summaryMap);