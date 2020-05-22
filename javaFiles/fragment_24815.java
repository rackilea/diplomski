DefaultHttpClient httpclient = new DefaultHttpClient();

HttpGet httpget = new HttpGet(url);
StringBuilder sb = new StringBuilder();

HttpResponse response = httpclient.execute(httpget);
HttpEntity entity = response.getEntity();

if (entity != null) {
  entity.consumeContent();
}

...

InputStream is = entity.getContent();
InputStreamReader isr = new InputStreamReader(is);
BufferedReader sb = new BufferedReader(isr);
String line = null;

while ( (line = br.readLine()) != null) {
     sb.append(line + "\n");
    }
    is.close();

    result=sb.toString();

   // before conversion to JSONArray print it:
   Log.d("Fess", result);

   jArray = new JSONArray(result);