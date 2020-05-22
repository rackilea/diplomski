AsyncHttpClient fileDownload = new AsyncHttpClient();
String[] allowedContentTypes = new String[] { "image/png", "image/jpeg" };
fileDownload.get("http://server.com/file.png", new BinaryHttpResponseHandler(allowedContentTypes) {
       @Override
       public void onSuccess(byte[] fileData) {
        //Do Something here to view files in activity  
         Bitmap bmp=BitmapFactory.decodeByteArray(fileData,0,fileData.length); 
         ImageView img = (ImageView) findViewById (R.id.imageview1);
         img.setImageBitmap(bmp);
         }