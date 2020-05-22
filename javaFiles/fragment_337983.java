// invoke service after setting necessary parameters
        clientConfig = new ClientConfig();
        clientConfig.register(MultiPartFeature.class);
        client =  ClientBuilder.newClient(clientConfig);
        client.property("accept", "application/zip");
        webTarget = client.target(httpURL);

        // invoke service
        invocationBuilder = webTarget.request();
        //          invocationBuilder.header("Authorization", "Basic " + authorization);
        response = invocationBuilder.get();

        // get response code
        responseCode = response.getStatus();
        System.out.println("Response code: " + responseCode);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed with HTTP error code : " + responseCode);
        }

        // get response message
        responseMessageFromServer = response.getStatusInfo().getReasonPhrase();
        System.out.println("ResponseMessageFromServer: " + responseMessageFromServer);

        // read response string
        inputStream = response.readEntity(InputStream.class);
        qualifiedDownloadFilePath = DOWNLOAD_FILE_LOCATION + "MyJerseyZippedFile.zip";
        outputStream = new FileOutputStream(qualifiedDownloadFilePath);
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }