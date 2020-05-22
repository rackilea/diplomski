private static class JSONAdapter extends JSONObject {

    private JsonNode jackson;

    public JSONAdapter(JsonNode jackson) {
        this.jackson = jackson;
    }

    @Override
    public Iterator<String> keys() {
        return jackson.fieldNames();
    }

    @Override
    public Object opt(String key) {
        return get(key);
    }

    @Override
    public Object get(String key) throws JSONException {
        JsonNode nested = jackson.get(key);
        if (nested.isObject()) {
            return new JSONAdapter(nested);
        } else if (nested.isTextual()) {
            return nested.asText();
        } else if (nested.isNumber()) {
            return nested.asDouble();
        } else if (nested.isBoolean()) {
            return nested.asBoolean();
        }
        return null;
    }

}