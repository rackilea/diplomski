List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
nameValuePairs.add(new BasicNameValuePair("Username","Your username"));
nameValuePairs.add(new BasicNameValuePair("Password","Your password"));
post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
HttpResponse response = client.execute(post);
BufferedReader rd = new BufferedReader(new InputStreamReader(
   response.getEntity().getContent()));
   String line = "";
   while ((line = rd.readLine()) != null) {
      System.out.println(line);
   }