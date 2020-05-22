Http.MultipartFormData body = request().body().asMultipartFormData();        
List<Http.MultipartFormData.FilePart> fileParts = body.getFiles();
     for (Http.MultipartFormData.FilePart filePart : fileParts) {
             if (filePart.getFilename().toLowerCase().endsWith(".png")) { 
             String filename = filePart.getFilename();
Files.write(Paths.get(filename + ".png"), readContentIntoByteArray((File) filePart.getFile()));

             } else {
                  return badRequest("Invalid request, only PNGs are allowed.");

             }
         }