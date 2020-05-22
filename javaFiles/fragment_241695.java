class ImageUploadTask extends AsyncTask<Void, Void, String> {
 private String webAddressToPost = "Your URL";

 // private ProgressDialog dialog;
 private ProgressDialog dialog = new ProgressDialog(MainActivity.this);

 @Override
 protected void onPreExecute() {
  dialog.setMessage("Uploading...");
  dialog.show();
 }

 @Override
 protected String doInBackground(Void... params) {
  try {
   HttpClient httpClient = new DefaultHttpClient();
   HttpContext localContext = new BasicHttpContext();
   HttpPost httpPost = new HttpPost(webAddressToPost);

   MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE);

   ByteArrayOutputStream bos = new ByteArrayOutputStream();
   bitmap.compress(CompressFormat.JPEG, 100, bos);
   byte[] data = bos.toByteArray();
   String file = Base64.encodeBytes(data);

   entity.addPart("uploaded", new StringBody(file));
   entity.addPart("someOtherStringToSend", new StringBody("your string here"));

   httpPost.setEntity(entity);
   HttpResponse response = httpClient.execute(httpPost,localContext);
   BufferedReader reader = new BufferedReader(new InputStreamReader(
     response.getEntity().getContent(), "UTF-8"));

   String sResponse = reader.readLine();
   return sResponse;
  } catch (Exception e) {
   // something went wrong. connection with the server error
  }
  return null;
 }

 @Override
 protected void onPostExecute(String result) {
  dialog.dismiss();
  Toast.makeText(getApplicationContext(), "file uploaded",Toast.LENGTH_LONG).show();
 }
}