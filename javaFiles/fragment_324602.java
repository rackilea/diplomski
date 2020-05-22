// Building Parameters
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("format", "json"));
        params.add(new BasicNameValuePair("format", "json"));
        params.add(new BasicNameValuePair("format", "json"));
        JSONObject json = jsonParser.makeHttpRequest(URL, "GET", params);