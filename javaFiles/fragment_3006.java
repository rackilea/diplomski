public static String queryString(Map<String, Object> values) {
    StringBuilder sbuf = new StringBuilder();
    String separator = "";

    for (Map.Entry<String, Object> entry : values.entrySet()) {
        String value = entry.getValue() == null
                ? "" : String.valueOf(entry.getValue());
        sbuf.append(separator);
        sbuf.append(urlEncode(entry.getKey()));
        sbuf.append('=');
        sbuf.append(urlEncode(value));
        separator = "&";
    }

    return sbuf.toString();
}

static String urlEncode(String value) {
    try {
        return URLEncoder.encode(value, "UTF-8");
    } catch (UnsupportedEncodingException e) {
        return value;
    }
}