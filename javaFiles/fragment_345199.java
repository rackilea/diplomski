public class Convertor {

    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        String json = "{\"value\":\"yu592e04-o9d5-8724-92a8-c5034df13cae\",\"expiration\":\"Jul 25, 2016 4:14:31 PM\",\"tokenType\":\"bearer\",\"refreshToken\":{\"expiration\":\"Sep 24, 2016 3:14:31 PM\",\"value\":\"bb6b7d65-a938-h75b-9cc5-d78b38e7adf9\"}}";
        Convertor converter = new Convertor();
        UserToken token = converter.fromJson(json);
        System.out.println(token);

    }

    public UserToken fromJson(String json) throws JsonParseException, JsonMappingException, IOException {
        UserToken token = (UserToken) new ObjectMapper().readValue(json, UserToken.class);

        return token;
    }

}

class UserToken {

    String value;
    String expiration;
    String tokenType;
    RefreshToken refreshToken;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public RefreshToken getRefreshToken() {
        return refreshToken;
    }

    @JsonProperty("refreshToken")
    public void setRefreshToken(RefreshToken refreshToken) {
        this.refreshToken = refreshToken;
    }



    @Override
    public String toString() {

        return "value " + value + "expiration " + expiration + "refreshToken.Expiration " + refreshToken.getExpiration()
                + " refreshToken.getValue: " + refreshToken.getValue();
    }
}

class RefreshToken {
    String expiration;
    String value;

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}