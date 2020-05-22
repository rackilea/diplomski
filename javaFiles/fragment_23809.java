return HttpRequest
        .create("put", url)
        .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
        .body(params.toJSONString())
        .send()
        .bodyText();
}