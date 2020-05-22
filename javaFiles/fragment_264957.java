@POST
@Consumes(MediaType.MULTIPART_FORM_DATA)
public void test(@Context HttpServletRequest request) {
    ServletFileUpload uploader = new ServletFileUpload(new DiskFileItemFactory());
    try {
        List<FileItem> parseRequest = uploader.parseRequest(request);
        for (FileItem fileItem : parseRequest) {
            if (fileItem.isFormField()) {
                System.out.println(fileItem.getFieldName() + ": "
                        + fileItem.getString());
            }

        }
    } catch (FileUploadException e) {
        e.printStackTrace();
    }
}