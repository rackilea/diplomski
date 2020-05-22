//set .lic to mime type
  String filename = "xxx.lice";
  String mimeType = new MimetypesFileTypeMap().getContentType(filename);
  response.setContentType( mimeType);
  response.setHeader( "Content-Disposition", "attachment;filename=" + filename );
  // Read the file content as a byte array
  java.io.File liceFile = new java.io.File("[File Path]");
  byte[] fileBytes = new byte[(int)liceFile.length()];
  java.io.FileInputStream liceFileStream = new java.io.FileInputStream(liceFile);
  liceFileStream.read(fileBytes);
  liceFileStream.close();
  //Push that byte array to the browser (user).
  ServletOutputStream sos = response.getOutputStream();
  sos.write(fileBytes);