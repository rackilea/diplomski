HttpClient httpclient = new DefaultHttpClient();
        HttpPost httppost = new HttpPost(url);

        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);
            nameValuePairs.add(new BasicNameValuePair("var1", editVar1.getText().toString()));
            nameValuePairs.add(new BasicNameValuePair("var2",editVar2.getText().toString()));
            nameValuePairs.add(new BasicNameValuePair("var3",editVar3.getText().toString()));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = httpclient.execute(httppost);