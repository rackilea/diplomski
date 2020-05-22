PipedOutputStream pipedOutputStream = new PipedOutputStream();
PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(pipedOutputStream);

FormDataMultiPart multiPart = new FormDataMultiPart();
multiPart.bodyPart(jsonObject, MediaType.APPLICATION_JSON_TYPE);
String mimeType = "application/octet-stream";

// Multipart streaming.
// Write to the PipedOutputStream in a separate thread
Runnable runnable = new Runnable() {
    public void run() {
        try {
            restDAO.readData(bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
};

Thread fileThread = new Thread(runnable, "MultiPartFileStreamer");
fileThread.start();
final StreamDataBodyPart streamDataBodyPart = new StreamDataBodyPart(
    "file", pipedInputStream, data.getContentFileName(), 
    MediaUtils.stringToMediaType(mimeType));
multiPart.bodyPart(streamDataBodyPart);

return Response.ok(multiPart, MediaType.MULTIPART_FORM_DATA).build();