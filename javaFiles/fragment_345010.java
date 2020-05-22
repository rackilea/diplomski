server.write(
    "HTTP/1.0 200 OK\r\nContent-Type: " + 
    mimeMap.getContentType(fileN.substring( fileN.lastIndexOf("/") + 1 )) + 
    "\r\nContent-Length: " + 
    fileC.length + 
    "\r\n\r\n"
   );
  server.write(
    fileC
   );