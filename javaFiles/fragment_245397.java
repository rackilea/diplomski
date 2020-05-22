List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

for (FileItem item : items) {
    if (item.isFormField()) {
        // Process normal fields here.
    }
}            

for (FileItem item : items) {
    if (!item.isFormField()) {
        // Process file fields here.
    }
}