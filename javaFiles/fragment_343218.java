Map<String, String> params = new HashMap<>();
    params.put("foo", "hello");
    params.put("bar", "world");

    WebClient webClient = WebClient.create("http://url"); 
    for (Entry<String, String> entry : params.entrySet()) {
        webClient.query(entry.getKey(), entry.getValue());
    }

    Response res = webClient.get();