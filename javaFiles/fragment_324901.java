Bitmap bitmap = resizeBitMapImage1(exsistingFileName, 800, 600);
ByteArrayOutputStream stream = new ByteArrayOutputStream();
bitmap.compress(Bitmap.CompressFormat.JPEG,30, stream);
StrictMode.ThreadPolicy policy = new     StrictMode.ThreadPolicy.Builder().permitAll().build();
StrictMode.setThreadPolicy(policy);

ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
nameValuePairs.add(new BasicNameValuePair("image_data", Base64.encodeBytes(stream.toByteArray())));

// image_str = null;
stream.flush();
stream.close();
bitmap.recycle();
nameValuePairs.add(new BasicNameValuePair("FileName", FileName));

String url = "http://www.xyz.com/upload.aspx";
HttpClient httpclient = new DefaultHttpClient();
HttpPost httppost = new HttpPost(url);
httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
HttpResponse response1 = httpclient.execute(httppost);
Log.i("DataUploaderOffline_Image ","Status--> Completed");