CloseableHttpClient httpClient = HttpClients.custom().build();
        HttpPost getRequest = new HttpPost("http://search.maven.org/solrsearch/select?q=1:<JAR CHECKSUM>&rows=1&wt=json");
        getRequest.addHeader("accept", "application/json");

        HttpResponse response = httpClient.execute(getRequest);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatusLine().getStatusCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (response.getEntity().getContent())));

        String output;
        StringBuffer outputBuffer = new StringBuffer("");
        while ((output = br.readLine()) != null) {
            outputBuffer.append(output);
        }

        JSONObject jsonObj = new JSONObject(outputBuffer.toString());
        LOGGER.info("MAVEN Compatible Dependency Found: " + jsonObj.getJSONObject ("response").getInt("numFound"));

        if (jsonObj.getJSONObject ("response").getInt("numFound") > 1) {
            JSONArray jsonArray = jsonObj.getJSONObject ("response").getJSONArray("docs");
            JSONObject object = (JSONObject) jsonArray.get(0);
            LOGGER.info(object.getString("g"));
            LOGGER.info(object.getString("a"));
            LOGGER.info(object.getString("v"));
        }