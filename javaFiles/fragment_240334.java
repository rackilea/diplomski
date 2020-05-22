JSONArray elements=new JSONArray();
  JSONObject aux=new JSONObject().put("name", "name1");
    aux.put("price", 10);
    array.put(aux);

    aux=new JSONObject().put("name1", "name2");
    aux.put("price", 20);
    array.put(aux);

List<NameValuePair> parameters= new ArrayList<NameValuePair>();
parameters.add(new BasicNameValuePair("json", elements.toString()));
HttpPost post = new HttpPost(url);
post.setEntity(new UrlEncodedFormEntity(pairs));
HttpClient cliente = createHttpClient();
return cliente.execute(post);