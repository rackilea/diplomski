private final WS.WSRequest getRequest (String url) {
    WS.WSRequest req = WS.url(overwriteBaseUrl(url) + getPath());

    for (String key: headers.keySet()) {
        req.setHeader(key, headers.get(key));
    }

    String body = getBody();
    if (body == null) {
        body = "";
    }

    req.body(body);

    return req;
}

public void send (WSMockableSender client, Office365Credentials cred, String url) throws IOException, InvalidCrmCredentialsException, MalformedResponseException {

    WS.WSRequest req = getRequest(url);
    addAuthHeaderToRequest(cred, req);

    // execute the request
    WSResponse response;
    response = new WSResponse(client.post(req));

    System.out.println("Response received!");

    // check for 401, not authorized
    if (response.getStatus() == 401) {
        throw new InvalidCrmCredentialsException("401 - Not authorized! " + req.url);
    }

    processResponse(response);
}