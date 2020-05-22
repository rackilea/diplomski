File file = new File("path/to/file");
String message = "This is a multipart post";
MultipartEntityBuilder builder = MultipartEntityBuilder.create();
builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);

if (postParams != null) {
    Iterator<Entry<String, String>> itParms = postParams.entrySet().iterator();
    while (itParms.hasNext()) {
        Entry<String, String> entry = itParms.next();

        builder.addTextBody(entry.getKey(), entry.getValue(), ContentType.DEFAULT_BINARY);
    }
}

builder.addTextBody("text", message, ContentType.DEFAULT_BINARY);

HttpEntity entity = builder.build();
httpPost.setEntity(entity);