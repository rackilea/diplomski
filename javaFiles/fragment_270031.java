abstract class Tokens {
    Map<String, String> tokens = new LinkedHashMap<>();

    @JsonAnyGetter
    public Map<String, String> getTokens() {
        return tokens;
    }

    @JsonAnySetter
    public void addToken(String key, String value) {
        tokens.put(key, value);
    }

}