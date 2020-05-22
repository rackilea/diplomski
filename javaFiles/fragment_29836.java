public String callRestExample(String service, String rest) throws IOException {
    String url = service;
    if (jsessionid != null)
        url += "/services/" + rest + ";jsessionid=" + jsessionid;

    HttpURLConnection conn = restClient.get(url);
    StringBuilder responseBuilder = new StringBuilder();
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    String input;
    while ((input = in.readLine()) != null) {
        responseBuilder.append(input);
    }
    in.close();

    String response = responseBuilder.toString();
    if (jsessionid == null) {
        int index = response.indexOf("jsessionid");
        jsessionid = response.substring(index + 13, index + 45);
        tgt = getTicketGrantingTicket(username, password);
        String st = getServiceTicket(service, tgt);
        commitJsessionid(service, jsessionid, st);
        callRestExample(service, rest);
    }

    return response;
}