ServletContext servletContext = (ServletContext) externalContext.getContext();
String contentType = servletContext.getMimeType(file.getName());

if (contentType == null) {
    contentType = "application/octet-stream";
}

response.setContentType(contentType);
// ...