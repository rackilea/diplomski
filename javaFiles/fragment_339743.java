public class JWK{
    String n;
    String e;
    //getters and setters
} 

ObjectMapper mapper = new ObjectMapper();
JWK jwk = mapper.readValue(publicKeyJson, JWK.class);