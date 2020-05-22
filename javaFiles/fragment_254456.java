for (FileItem item : formItems) {
    if (item.isFormField()) {
        // Process regular form field (input type="text|radio|checkbox|etc", select, etc).
        String fieldname = item.getFieldName();
        String fieldvalue = item.getString();
        // ... (do your job here)
    } else {
        // Process form file field (input type="file").
        String fieldname = item.getFieldName();
        String filename = FilenameUtils.getName(item.getName());
        InputStream filecontent = item.getInputStream();
        // ... (do your job here)
    }
}