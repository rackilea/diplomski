String form_field="";
 FileItem fileItem = null; 
 if (ServletFileUpload.isMultipartContent(request)) {
            ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
            try {
                fileItemsList = servletFileUpload.parseRequest(request);
            } catch (FileUploadException ex) {
                out.print(ex);
            }
            String optionalFileName = "";
            Iterator it = fileItemsList.iterator();
            while (it.hasNext()) {
                FileItem fileItemTemp = (FileItem) it.next();
                if (fileItemTemp.isFormField()) {
                    if (fileItemTemp.getFieldName().equals("form_field")) {
                        form_field = fileItemTemp.getString();
                    }
                } else {
                    if (fileItemTemp.getFieldName().equals("file")) {
                        fileItem = fileItemTemp;
                    }
                }
            }
        }