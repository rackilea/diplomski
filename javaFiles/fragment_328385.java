public static List<Map<String, String>> parseJson(URI uri, String encoding) {
    List<Map<String, String>> flatJson = null;
    String json = "";

    try {
        json = IOUtils.toString(uri, encoding);
        flatJson = parseJson(json);
    } catch (IOException e) {
        LOGGER.error("JsonFlattener#ParseJson(uri, encoding) IOException: ", e);
    } catch (Exception ex) {
        LOGGER.error("JsonFlattener#ParseJson(uri, encoding) Exception: ", ex);
    }

    return flatJson;
}