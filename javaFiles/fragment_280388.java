String fileName = file.getFileIdentifier();
byte[] fileData = file.getStoredFile(); // BTW: Any chance to get this as InputStream? This is namely memory hogging.

response.setContentType("application/x-bzip2");
response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

OutputStream output = null;

try {
     output = new CBZip2OutputStream(response.getOutputStream());
     output.write(fileData);
} finally {
     output.close();
}