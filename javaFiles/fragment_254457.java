for (FileItem item : formItems) {
    // processes only fields that are not form fields
    if (!item.isFormField()) {
        String fileName = new File(item.getName()).getName();
        fileName1+=fileName;
        String filePath = uploadPath + File.separator + fileName;
        File storeFile = new File(filePath);
        // saves the file on disk
        item.write(storeFile);
    } else {
        //here...
        String fieldname = item.getFieldName();
        String fieldvalue = item.getString();
        if (fieldname.equals("p_data")) {
            //logic goes here...
        } else if (fieldname.equals("upload_wall_gallery")) {
            //next logic goes here...
        }
    }
}