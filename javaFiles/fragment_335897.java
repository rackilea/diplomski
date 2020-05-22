try {
    List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
    for (FileItem item : items) {
        if (item.getFieldName().equals("fieldname")) {
            String fileName = FilenameUtils.getName(item.getName());
            String fileContentType = item.getContentType();
            InputStream fileContent = item.getInputStream();
            // ... (do your job here)
        }
    }
} catch (FileUploadException e) {
    throw new ServletException("Cannot parse multipart request.", e);
}