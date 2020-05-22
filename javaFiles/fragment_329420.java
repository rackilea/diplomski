public Tweets mapJavaObject() {

String jsonFile = twitterFile.getName();
Tweets ret = null; 

System.out.println("Mapping JSON to WeatherTweet Class.");

ObjectMapper mapper = new ObjectMapper();
mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
try {
    ret = (Tweets) mapper.readValue(new File(jsonFile), Tweets.class);
} catch (JsonParseException e) {
    e.printStackTrace();
} catch (JsonMappingException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}

System.out.println("Finished Mapping of JSON File.");
retrun ret;
}