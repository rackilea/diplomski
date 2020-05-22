URI uri = new URI("https://XXX:YYY@api.browserstack.com/automate/sessions/"
        + sessionId + ".json");
HttpPut putRequest = new HttpPut(uri);

ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
nameValuePairs.add((new BasicNameValuePair("status", "failed")));
nameValuePairs.add((new BasicNameValuePair("reason", "")));
putRequest.setEntity(new UrlEncodedFormEntity(nameValuePairs));

HttpClientBuilder.create().build().execute(putRequest);