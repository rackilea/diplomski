// Produce the output
ByteArrayOutputStream out = new ByteArrayOutputStream();
Writer writer = new OutputStreamWriter(out, "UTF-8");
writeXml(writer);

// Create the request
HttpPost request = new HttpPost(uri);
request.setEntity(new ByteArrayEntity(out.toByteArray()));

// Send the request
DefaultHttpClient client = new DefaultHttpClient();
HttpResponse response = client.execute(request);