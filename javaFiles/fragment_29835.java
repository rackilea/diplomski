public boolean login(String service, String jsessionid) throws IOException {
    tgt = getTicketGrantingTicket(username, password);
    String st = getServiceTicket(service, tgt);
    commitJsessionid(service, jsessionid, st);
    this.jsessionid = jsessionid;
    return true;
}

public String getTicketGrantingTicket(String username, String password) throws IOException {
    Map<String, Object> params = new LinkedHashMap<>();
    params.put("username", username);
    params.put("password", password);
    HttpURLConnection conn = restClient.post(casUrl + "/v1/tickets", params);
    StringBuilder responseBuilder = new StringBuilder();
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    String input;
    while ((input = in.readLine()) != null) {
        responseBuilder.append(input);
    }
    in.close();

    String response = responseBuilder.toString();
    if (conn.getResponseCode() == 400) {
        throw new AuthenticationException("bad username or password");
    }
    String location = conn.getHeaderField("Location");
    return location;
}

public String getServiceTicket(String service, String tgt) throws IOException {
    Map<String, Object> params = new LinkedHashMap<>();

    params.put("service", service + "/j_acegi_security_check");

    HttpURLConnection conn = restClient.post(tgt, params);
    StringBuilder responseBuilder = new StringBuilder();
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    String input;
    while ((input = in.readLine()) != null) {
        responseBuilder.append(input);
    }
    in.close();

    String response = responseBuilder.toString();

    return response;
}

public String commitJsessionid(String service, String jsessionid, String st) throws IOException {
    HttpURLConnection conn = restClient.get(service + "/j_acegi_security_check;jsessionid=" + jsessionid + "?ticket=" + st);
    StringBuilder responseBuilder = new StringBuilder();
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    String input;
    while ((input = in.readLine()) != null) {
        responseBuilder.append(input);
    }
    in.close();

    String response = responseBuilder.toString();

    return response;
}

public boolean validateServiceTicket(String service, String st) throws IOException {
    HttpURLConnection conn = restClient.get(casUrl + "/proxyValidate?ticket=" + st + "&service=" + service + "/j_acegi_security_check");
    StringBuilder responseBuilder = new StringBuilder();
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    String input;
    while ((input = in.readLine()) != null) {
        responseBuilder.append(input);
    }
    in.close();

    String response = responseBuilder.toString();

    return response.toString().contains("authenticationSuccess");
}