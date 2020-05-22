HttpResponse response;
    String responseBody;
    try {
        response = httpclient.execute(request);
        int sc = response.getStatusLine().getStatusCode();
        if (sc != HttpStatus.SC_OK)
            throw new SystemException("google status code : " + sc);

        HttpEntity entity = response.getEntity();
        if (entity == null)
            throw new SystemException("response entity null");
        responseBody = EntityUtils.toString(entity);
    } catch (Exception e) {
        request.abort();
        throw new SystemException("Problem when executing Google request", e);
    }