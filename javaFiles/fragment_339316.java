public List<String> convertToStringArray(File file) throws IOException {
    List<String> result = new ArrayList<>();
    String data = FileUtils.readFileToString(file, "UTF-8");
    JsonArray entries = (new JsonParser()).parse(data).getAsJsonArray();
    for (JsonElement obj : entries)
        result.add(obj.toString());
    return result;
}