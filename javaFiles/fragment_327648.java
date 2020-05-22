HttpClient client = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost("Your URL");

        //add your headers like this
        httpPost.setHeader("Content-type", "application/xml");
        httpPost.setHeader("Accept", "application/xml");

        //add your parameters like this
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
        nameValuePairs.add(new BasicNameValuePair("param1", "4611"));
        nameValuePairs.add(new BasicNameValuePair("param2", "818"));
        nameValuePairs.add(new BasicNameValuePair("param3", "818"));
        nameValuePairs.add(new BasicNameValuePair("submit", "Find Status"));

        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        HttpResponse response = client.execute(httpPost); 
        HttpEntity httpEntity = response.getEntity();

        //get response as String or what ever way you need
        String response = EntityUtils.toString(httpEntity);