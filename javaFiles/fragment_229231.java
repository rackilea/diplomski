MovieRESTAPIClient client = ProxyFactory.create(XClient.class,"http://api.xxx.com");
String json_string = client.getMovieInformation("taken");

ObjectMapper om = new ObjectMapper();
Movie movie = null;
try {
    movie = om.readValue(json_string, Movie.class);
} catch (JsonParseException e) {
myLogger.severe(e.toString());
e.printStackTrace();
} catch (JsonMappingException e) {
myLogger.severe(e.toString());
    e.printStackTrace();
} catch (IOException e) {
    myLogger.severe(e.toString());
    e.printStackTrace();
}