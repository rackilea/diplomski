// Read response data into buffer
    char[] buffer = new char[(int)responseEntity.getContentLength()];
    InputStream stream = responseEntity.getContent();
    InputStreamReader reader = new InputStreamReader(stream);
    reader.read(buffer);
    stream.close();

    JSONObject jsobj = new JSONObject(new String(buffer));