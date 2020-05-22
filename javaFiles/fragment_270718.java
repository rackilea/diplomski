String x = "{'candidateId':'k','candEducationId':1,'activitiesSocieties':'Activities for cand1'}";
ObjectMapper mapper = new ObjectMapper();
mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
JsonNode df = mapper.readValue(x, JsonNode.class);
System.out.println(df.toString());
// output: {"candidateId":"k","candEducationId":1,"activitiesSocieties":"Activities for cand1"}