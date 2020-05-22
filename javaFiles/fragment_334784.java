static String str = "\"import\" : \"static\",\"path\" : true";

static void test(String str) {
    Map<String, String> map = new HashMap<String, String>();
    String[] parts = str.split("(:|,)");
    for (int i = 0; i < parts.length - 1; i+=2) {
        map.put(getUnquotedStr(parts[i]), getUnquotedStr(parts[i+1]));
    }
    System.out.println(map.size() + " entries: " + map); // 2 entries: {path=true, import=static}
    boolean isExportSet = "".equals(map.get("import"));
    boolean isPathSet = "true".equals(map.get("path"));
    System.out.println(isExportSet + " - " + isPathSet);
}

private static String getUnquotedStr(String str) {
    return str.replaceAll("\"", "").trim();
}