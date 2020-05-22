HttpPost request = new HttpPost(url);

List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();  
nameValuePairs.add(new BasicNameValuePair("email","my email"));  
nameValuePairs.add(new BasicNameValuePair("name","my name"));
httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

response = client.execute(request);