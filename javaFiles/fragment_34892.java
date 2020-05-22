if (path.endsWith("/upload")) {
    Part filePart = request.getPart("file"); 
    String filename = getFilename(filePart);

   //send it to a server
   sendPost("http://127.0.0.1:8888", filename);