File file = null;
    try {
        // Transform baos into file
        InputStream is = new ByteArrayInputStream(baos.toByteArray());

        file = File.createTempFile("file ", "zip");
        FileUtils.copyInputStreamToFile(is, file);

        HttpClient httpclient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);

        // Send file as part of body
        FileBody uploadFilePart = new FileBody(file);
        MultipartEntity reqEntity = new MultipartEntity();
        reqEntity.addPart("file", uploadFilePart);
        httpPost.setEntity(reqEntity);

        HttpResponse response = httpclient.execute(httpPost);
        return response.toString();

    } finally {
        if (file != null) {
            file.delete();
        }
    }