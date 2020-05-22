//this example from apache httpcomponents doc
List<NameValuePair> formparams = new ArrayList<NameValuePair>();
formparams.add(new BasicNameValuePair("param1", "value1"));
formparams.add(new BasicNameValuePair("param2", "value2"));
UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formparams, "UTF-8");
HttpPost httppost = new HttpPost("http://localhost/handler.do");
httppost.setEntity(entity);