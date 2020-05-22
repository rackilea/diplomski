Bitmap bitmap = yourBitmapHere;

// Creates Byte Array from picture
ByteArrayOutputStream baos = new ByteArrayOutputStream();
bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos); // Not sure whether this should be jpeg or png, try both and see which works best
URL url = new URL("http://api.imgur.com/2/upload");

//encodes picture with Base64 and inserts api key
String data = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(Base64.encode(baos.toByteArray(), Base64.DEFAULT).toString(), "UTF-8");
data += "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode(YOUR_API_KEY, "UTF-8");

// opens connection and sends data
URLConnection conn = url.openConnection();
conn.setDoOutput(true);
OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
wr.write(data);
wr.flush();