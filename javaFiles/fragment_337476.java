List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
for (FileItem item : items) {
    if (item.isFormField()) {
        // Process regular field.
    } else {
        // Process uploaded file.
    }
}