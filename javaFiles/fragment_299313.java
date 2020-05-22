DefaultHttpClient httpclient = new DefaultHttpClient();
 HttpPost httppost = new HttpPost("https://<SERVER>:8088/services/collector/event");
 httppost.addHeader("Authorization", " Splunk <token id>");
 String eventStr = "{sourcetype=_json, index=main, event={ <JSON> }}"
 httppost.setEntity(new StringEntity(eventStr);
 HttpResponse response = httpclient.execute(httppost);
 HttpEntity entity = response.getEntity();
 System.out.println("response: " + entity);