boolean isMultipart = ServletFileUpload.isMultipartContent(request);
    if (!isMultipart) {
    } else {
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<?> items = null;
        String stringUrl = null;
        try {
            items = upload.parseRequest(request);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        Iterator<?> itr = items.iterator();
        while (itr.hasNext()) {
            FileItem item = (FileItem) itr.next();
            if (item.isFormField()) {
                System.out.println("Form Field");
                String parameterName = item.getName();
                if(parameterName.equals("stringurl")) {
                    stringUrl = item.getString();
                }
            } else {
                // upload file logic here
            }
        }
    }