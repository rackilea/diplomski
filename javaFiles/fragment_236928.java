RestClient post = RestClient.create()
    .method("POST")
    .host(host)
    .path(path)
    .header("Content-Type", "application/json");
//    .contentType("application/json");