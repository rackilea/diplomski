private <T> Observable<String> executeHttpAsync(String url, String httpMethod, Entity<T> entity) {
    return httpClient.target(url)
            .request()
            .headers(httpHeaders) // assuming httpHeaders is something global as in your example
            .rx()
            .method(httpMethod, entity)
            .map(resp -> {
                if (200 != resp.getStatus()) {
                    throw new RuntimeException("Bad status code " + resp.getStatus());
                } else {
                    if (!resp.hasEntity()) {
                        // return null; // or error?
                        throw new RuntimeException("Empty response"); // or empty?
                    } else {
                        try {
                            return resp.readEntity(String.class);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex); // wrap exception into unchecked
                        }
                    }
                }
            })
            .observeOn(Schedulers.computation());
}

private Observable<String> executeGetAsync(String url) {
    return executeHttpAsync(url, "GET", null);
}

private Observable<String> executePostAsync(String url, String json) {
    return executeHttpAsync(url, "POST", Entity.json(json));
}