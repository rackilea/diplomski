private Response POST(IHTTPSession) {

    try {
        Map<String, String> files = new HashMap<String, String>();
        session.parseBody(files);

        Set<String> keys = files.keySet();
        for(String key: keys){
            String name = key;
            String loaction = files.get(key);

            File tempfile = new File(loaction);
            Files.copy(tempfile.toPath(), new File("destinamtio_path"+name).toPath(), StandardCopyOption.REPLACE_EXISTING);
        }


    } catch (IOException | ResponseException e) {
        System.out.println("i am error file upload post ");
        e.printStackTrace();
    }

    return createResponse(Status.OK, NanoHTTPD.MIME_PLAINTEXT, "ok i am ");
}