Single<HttpResponse<JsonNode>> singleHttpClient = httClient.post();
    singleHttpClient .toObservable().flatMap(httpResponse -> {
        if(httpResponse.getStatus() == 200) {
            JsonNode responseNode = httpResponse.getBody();
            List<JSONObject> blogObjects = iterateFrom(responseNode.getObject().getJSONArray("blogs"))
        }
        return Observable.fromIterable(blogObjects).toList().toObservable();
    }).flatMap(jsonObjects -> Observable.fromIterable(jsonObjects))
            .flatMap(jsonObject -> {
                return Observable.just(new Blog(jsonObject.getString("id"), jsonObject.getString("guid")));
            }).flatMap(blog -> {
        Single<HttpResponse<JsonNode>> singleHttpClient2 = httpClient2.post();
        singleHttpClient2.getParams().put("guid", blog.getImageGuid());
        return Observable.zipWith(singleHttpClient2.postAsBinary().toObservable(), (Blog blog, HttpResponse data)->blog.setData(data));
    }).subscribe(blog -> {
        doSomethingWith(blog); // How to access `blog` from here?
    });