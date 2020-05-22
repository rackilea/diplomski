/* Set the file properties*/
if(fileType == null) {
    response.setContentType("application/octet-stream");
} else {
    response.setContentType(fileType);
}
response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-cache");

/* Convert bytes to stream of objects*/
InputStream is = new ByteArrayInputStream(decodedDocument);

/*Download copying the content to destination file*/
IOUtils.copy(is, response.getOutputStream());
response.flushBuffer();