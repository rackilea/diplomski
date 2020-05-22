List<NameValuePair> params;
//and when making `HttpPost` you can do 
HttpPost httpPost = new HttpPost("Yoururl");
httpPost.setEntity(new UrlEncodedFormEntity(params));

//and while building parameters you can do somethin like this 
params.add(new BasicNameValuePair("name", "firemanavan"));
params.add(new BasicNameValuePair("cvr", "1245678"));
....