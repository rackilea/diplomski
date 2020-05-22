String body = "{}";
Map<String, String> headers = new HashMap<String, String>();
headers.put("Content-Type", "application/json");
WebResponse response = web.clientOf(url, headers)
    .transports(String.class)
    .over(Text.class)
    .post(body);