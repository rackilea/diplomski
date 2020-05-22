post("/upload", "multipart/form-data", (request, response) -> {

String location = "image";          // the directory location where files will be stored
long maxFileSize = 100000000;       // the maximum size allowed for uploaded files
long maxRequestSize = 100000000;    // the maximum size allowed for multipart/form-data requests
int fileSizeThreshold = 1024;       // the size threshold after which files will be written to disk

MultipartConfigElement multipartConfigElement = new MultipartConfigElement(
     location, maxFileSize, maxRequestSize, fileSizeThreshold);
 request.raw().setAttribute("org.eclipse.jetty.multipartConfig",
     multipartConfigElement);

Collection<Part> parts = request.raw().getParts();
for (Part part : parts) {
   System.out.println("Name: " + part.getName());
   System.out.println("Size: " + part.getSize());
   System.out.println("Filename: " + part.getSubmittedFileName());
}

String fName = request.raw().getPart("file").getSubmittedFileName();
System.out.println("Title: " + request.raw().getParameter("title"));
System.out.println("File: " + fName);

Part uploadedFile = request.raw().getPart("file");
Path out = Paths.get("image/" + fName);
try (final InputStream in = uploadedFile.getInputStream()) {
   Files.copy(in, out);
   uploadedFile.delete();
}
// cleanup
multipartConfigElement = null;
parts = null;
uploadedFile = null;

return "OK";
});