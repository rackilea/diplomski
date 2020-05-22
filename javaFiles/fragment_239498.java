String fileName = "something.zip" // should come from your domain instance
  String filePathAndName = "/downloads/${fileName}" // should come from your configuration
  response.setContentType("application/octet-stream")
  response.setHeader("Content-disposition", "attachment;filename=${fileName")

  // this will actually buffer/stream the file in 8k chunks instead of reading the entire file into memory.
  org.apache.commons.io.IOUtils.copy((new File(filePathAndName)).openStream(), response.outputStream)
  response.outputStream.flush()
  response.outputStream.close()