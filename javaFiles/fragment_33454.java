String formatMap(Map<String, String> map) {
    return Joiner.on(",").withKeyValueSeparator("=").join(map);
}

Map<String, String> parseMap(String formattedMap) {
    return Splitter.on(",").withKeyValueSeparator("=").split(formattedMap);
}