private static <T> List<T> load(JsonObject jsonObject, String param)
{
    return jsonObject.getJsonArray(param).stream()
                                         .map(Bla::getItem)
                                         .collect(Collectors.toList());
}