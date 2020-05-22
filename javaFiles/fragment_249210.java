CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpEntity entity = MultipartEntityBuilder.create().setMode(
HttpMultipartMode.BROWSER_COMPATIBLE).setBoundary("----WebKitFormBoundaryDeC2E3iWbTv1PwMC").setContentType(
ContentType.MULTIPART_FORM_DATA)
                .addBinaryBody("file",
                        new File("PATH"),
                        ContentType.APPLICATION_OCTET_STREAM, "filename.gcode")
                .addTextBody("select", "true", ContentType.MULTIPART_FORM_DATA).addTextBody("print", "true", ContentType.MULTIPART_FORM_DATA)
                .build();

        HttpPost httpPost = new HttpPost("http://localhost:5002/api/files/local");
        httpPost.addHeader("Host", "http://localhost:5002");
        httpPost.addHeader("X-Api-Key", "88CC15F3B5864CCAB19981A8B67A4071");
        httpPost.addHeader("Content-Type", "multipart/form-data; boundary=----WebKitFormBoundaryDeC2E3iWbTv1PwMC");
        httpPost.setEntity(entity);
        //betterPrint(httpPost);
        HttpResponse response = httpClient.execute(httpPost);

        HttpEntity result = response.getEntity();