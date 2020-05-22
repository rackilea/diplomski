private Bitmap LoadImage(String URL, BitmapFactory.Options options)
  {      
   Bitmap bitmap = null;
   InputStream in = null;      
      try {
        //  in = OpenHttpConnection(URL);
          bitmap = BitmapFactory.decodeStream(OpenHttpConnection(URL), null, options);
        //  in.close();

      } catch (IOException e1) {
          Log.e("erererere", e1.toString());
      }
      return bitmap;              
  }


private InputStream OpenHttpConnection(String strURL) throws IOException{
 InputStream inputStream = null;
 URL url = new URL(strURL);
 URLConnection conn = url.openConnection();


 try{
  HttpURLConnection httpConn = (HttpURLConnection)conn;
  httpConn.setRequestMethod("GET");
  httpConn.connect();

  if (httpConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
   inputStream = httpConn.getInputStream();
  }
 }

 catch (Exception ex)
 {
     Log.e("error",ex.toString());
 }
 return inputStream;
}