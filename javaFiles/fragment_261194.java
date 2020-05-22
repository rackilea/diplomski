Map body = new HashMap();
// Fill in body with data
WebResponse response = web.clientOf(url)
    .transports(Map.class)
    .over(Json.class)
    .post(body);