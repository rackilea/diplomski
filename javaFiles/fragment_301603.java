final Response response = resource.client()
        .target("/assets/123")
        .request()
        .get();

    InputStream responseStream = (InputStream) response.getEntity();