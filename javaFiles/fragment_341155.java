OutputStream outputStream = connection.getOutputStream();
    PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, CHARSET), true);
    try {
        for(String key : keyValueMap.keySet()) {
            writer.append("--" + boundary).append(CRLF);
            writer.append("Content-Disposition: form-data; name=\"" + key + "\"").append(CRLF);
            writer.append("Content-Type: text/plain; charset=" + CHARSET).append(CRLF);
            writer.append(CRLF).append(keyValueMap.get(key)).append(CRLF).flush();
        }
        // Send binary file.
        writer.append("--" + boundary).append(CRLF);
        writer.append("Content-Disposition: form-data; name=\"batchFile\"; filename=\"" + fileToUpload.getName() + "\"").append(CRLF);
        writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(fileToUpload.getName())).append(CRLF);
        writer.append("Content-Transfer-Encoding: binary").append(CRLF);
        writer.append(CRLF).flush();
        Files.copy(fileToUpload.toPath(), outputStream);
        outputStream.flush(); // Important before continuing with writer!
        writer.append(CRLF).flush(); // CRLF is important! It indicates end of boundary.
        writer.println("--" + boundary + "--");
    } finally {
        if (writer != null) writer.close();
    }