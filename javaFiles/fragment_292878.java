@Override
protected MultipartParsingResult parseRequest(HttpServletRequest request) {

    String encoding = determineEncoding(request);
    FileUpload fileUpload = prepareFileUpload(encoding);

    List<FileItem> fileItems;
    List<String> oversizedFields = new LinkedList<>();

    try {
        fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);
    } catch (FileUploadBase.SizeLimitExceededException ex) {
        fileItems = Collections.emptyList();
        request.setAttribute(ATTR_REQUEST_SIZE_EXCEEDED,
                KEY_REQUEST_SIZE_EXCEEDED);
    } catch (FileUploadException ex) {
        throw new MultipartException(MULTIPART_UPLOAD_ERROR, ex);
    }
    if (maxFileSize > -1) {
        for (FileItem fileItem : fileItems) {
            if (fileItem.getSize() > maxFileSize) {
                oversizedFields.add(fileItem.getFieldName());
                fileItem.delete();
            }
        }
    }
    if (!oversizedFields.isEmpty()) {
        request.setAttribute(ATTR_FIELDS_OVERSIZED, oversizedFields);
    }
    return parseFileItems((List<FileItem>) fileItems, encoding);
}