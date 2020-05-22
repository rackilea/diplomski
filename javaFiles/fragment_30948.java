private String expandFileName(String filename) {
    Pattern p = Pattern.compile("%([^%]*)%");
    Matcher m = p.matcher(filename);
    Map<String, String> env = getEnv();
    while (m.find()) {
        String var = m.group(1);
        String value = env.get(var.toLowerCase());
        if (value != null) {
            filename = filename.replaceAll("%" + var + "%",
                    Matcher.quoteReplacement(value));
        } else {
            return filename;
        }
        m = p.matcher(filename);
    }
    return filename;
}