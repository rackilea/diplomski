JsonResponseEntry getJsonReportResponse() throws IOException {
         String sReportURL = "https://someurl.com/v2/report/report?" +
                 "startts=" + getDateYesterday("ts") +
                 "&endts=" + getDateNow("ts") +
                 "&auth=" + getAuthCode();

         URL reportURL = new URL(sReportURL);
         URLConnection conn = reportURL.openConnection();
         BufferedReader buf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         ObjectMapper mapper = new ObjectMapper();
        JsonNode reportResult = mapper.readTree(buf);
         return convertJSonNodeToJsonResponseEntry(reportResult);
    }

    String getAuthCode() throws IOException {
        String sReportURL = "https://someurl.com/auth";
        URL reportURL = new URL(sReportURL);

        HttpURLConnection conn = (HttpURLConnection) reportURL.openConnection();
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.connect();

        String urlParameters = "username=myUserName&password=mypassword";
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        BufferedReader buf = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        ObjectMapper mapper = new ObjectMapper();
        AuthResponse response = mapper.readValue(buf, AuthResponse.class);
        return response.toString();
    }