String configAsString = "{ \"conversion_target\":\"answer_units\", \"answer_units\": { \"selector_tags\": [] } }";

JsonParser jsonParser = new JsonParser();
JsonObject customConfig = jsonParser.parse(configAsString).getAsJsonObject();    

Answers response = DC.convertDocumentToAnswer(doc, null, customConfig).execute();