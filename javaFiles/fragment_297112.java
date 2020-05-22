DiskFileUpload upload = new DiskFileUpload();
List<FileItem> items = upload.parseRequest(request);
   for (FileItem item : items) {
        if (item.isFormField()) {
                 //get form fields here 
         }
         else {
                  //process file upload here
          }}