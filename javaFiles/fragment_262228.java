DataInputStream dis;
...
HttpClient httpclient = new DefaultHttpClient();
HttpPost httppost = new HttpPost("http://localhost:8080");

BasicHttpEntity entity = new BasicHttpEntity();
entity.setChunked(true);
entity.setContentLength(-1);
entity.setContent(dis);

httppost.setEntity(entity);
HttpResponse response = null;
try {
     response = httpclient.execute(httppost);
} catch (ClientProtocolException e) {
    // TODO
} catch (IOException e) {
    // TODO
}
...
// processing http response....