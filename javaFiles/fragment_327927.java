@RequestMapping(value = "", method = RequestMethod.POST)
public void postTransportEvent(HttpServletRequest request) {
File streamedFile = new File("test.xml");

    try {
        InputStream inputStream = request.getInputStream();

        if (inputStream != null) {
            FileOutputStream outputStream = new FileOutputStream(streamedFile);

            byte[] buffer = new byte[10240];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.flush();
            outputStream.close();
        }

        inputFileStream.close();

    } catch (IOException e) {
        log.error(e.toString(), e);
    } finally {
        streamedFile.delete();
    }