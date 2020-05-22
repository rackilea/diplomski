public static <T> T getForEntity(String url, Class<T> clazz)  throws InterruptedException, 
                                                  ExecutionException, IOException {
    Response getResponse = callWithHttpGet(url);
    String getResponseJson = getResponse.getBody();
    ObjectMapper getResponseJsonMapper = new ObjectMapper();
    return getResponseJsonMapper.readValue(getResponseJson, clazz);        
}