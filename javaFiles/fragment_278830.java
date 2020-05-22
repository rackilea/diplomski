@RequestMapping(value = "/files/{file_name}", method = RequestMethod.GET)
public void getFile(
    @PathVariable("file_name") String fileName, 
    HttpServletResponse response) {
    try {
      // get your file as InputStream
      InputStream is = ...;
      // copy it to response's OutputStream
      org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
      response.flushBuffer();
    } catch (IOException ex) {
      log.info("Error writing file to output stream. Filename was '{}'", fileName, ex);
      throw new RuntimeException("IOError writing file to output stream");
    }

}