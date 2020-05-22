Map properties = new HashMap();
        List<FileItem> items;

        items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
        for (FileItem item : items) {
            if (item.isFormField()) {
                String fieldName = item.getFieldName();
                String fieldValue = item.getString();
                properties.put(fieldName, fieldValue);
            } else {

                String tempString = "d:/io";
                //String fileName = FilenameUtils.getName(item.getName());
                //fileNameWithOutExt = FilenameUtils.removeExtension(fileName);
                file = new File(tempString + '/' + item.getName());

                item.write(file);
            }
        }