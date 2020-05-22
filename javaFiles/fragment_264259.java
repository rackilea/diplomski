String mimeType = URLConnection.guessContentTypeFromName(toBeCopied.getName());
String contentDisposition = String.format("attachment; filename=%s", toBeCopied.getName());
int fileSize = Long.valueOf(toBeCopied.length()).intValue();

response.setContentType(mimeType);
response.setHeader("Content-Disposition", contentDisposition);
response.setContentLength(fileSize);