private String UrlMap(String s) {
    try {
        String url = "https://www.google.com/maps/search/?api=1&query=" + URLEncoder.encode(s, "UTF-8");
        return url;
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    }

return "";
}