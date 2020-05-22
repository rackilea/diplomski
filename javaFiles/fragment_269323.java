@PostMapping(value = "/")
public String payloader(@RequestBody String params ) throws IOException{
    LOGGER.debug("code is hitting");
    parse = params.split("\\|"); 
    String key;
    String value;
    String dyn;
    Map<String, String> predictionFeatureMap = mockconfig.getPredictionFeatureMap();

    if(parse.length!=18) {

        // Here you throw a custom runtime exception and pass what
        // parameters you want that will help you build your error 
        // message you are passing to your client.

        final String errorMessage = String.format(
            "Payload has incorrect amount of parts: expecting:%d actual:%d",
            predictionFeatureMap.size(), 
            parse.length);

        throw new MyException(errorMessage); 

    }
    else {
        key = params;
        value = predictionFeatureMap.get(key);
    }
    return value;
}