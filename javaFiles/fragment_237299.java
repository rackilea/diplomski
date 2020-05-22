Response response = target.request()
        .accept("application/json")
        .acceptEncoding("gzip")
        .get();

GZIPInputStream is = new GZIPInputStream(
                          response.readEntity(InputStream.class));