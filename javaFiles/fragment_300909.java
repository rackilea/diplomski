HttpClient client = new DefaultHttpClient();
File file = new File(selectedImagePath);
HttpPost post = new HttpPost(uploadUrl);

post.setHeader("token", myAuthToken);
post.setHeader("Content-type", "multipart/form-data; boundary=" + boundary);
MultipartEntity entity = new MultipartEntity(HttpMultipartMode.BROWSER_COMPATIBLE,
                    Constants.BOUNDARY, Charset.defaultCharset());

entity.addPart(Constants.MULTIPART_FORM_DATA_NAME, new FileBody(file));
post.setHeader("Accept", "application/json");
post.setHeader("Content-Type", "multipart/form-data; boundary=" + boundary);

post.setEntity(entity);

HttpResponse response = client.execute(post);
HttpEntity httpEntity = response.getEntity();
Log.d("Response", EntityUtils.toString(httpEntity));