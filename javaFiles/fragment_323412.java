class OAuth{
...
    public static String percentEncode(String s) {
            return URLEncoder.encode(s, "UTF-8")
                    .replace("+", "%20").replace("*", "%2A")
                    .replace("%7E", "~");
    }
...
}