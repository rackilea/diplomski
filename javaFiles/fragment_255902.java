public static ThisClass initFromJson(final String json) {
    final ObjectMapper mapper = new ObjectMapper();
    ThisClass item;
    try {
        item = mapper.readValue(json, ThisClass.class);
    } catch (IOException e) {
        return null;
    }

    return item;
}