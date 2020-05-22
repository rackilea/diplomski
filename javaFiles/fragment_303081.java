public void getFile(final HttpServletResponse response) {
  String file = (String) request.getParameter("file");
  response.setHeader("Content-Disposition",
                     "attachment;filename=" + file);
  response.setContentType("text/plain");

  File down_file = new File("log/" + file);
  FileInputStream fileIn = new FileInputStream(down_file);
  ByteStreams.copy(fileIn, response.getOutputStream());
  response.flushBuffer();

  return null;
}