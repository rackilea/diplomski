Set<FileUpload> fileUploads = routingContext.fileUploads();
FileUpload fileUpload = fileUploads.iterator().next();
fileUpload.contentType();
if(!fileUpload.contentType().startsWith("image/")){
    routingContext.response().putHeader("content-type", "text/html").end("Please upload an image.");
}else{
    // Process your image
}