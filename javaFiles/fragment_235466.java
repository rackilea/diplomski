FileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload upload = new ServletFileUpload(factory);
List<FileItem> items = upload.parseRequest(request);
for (FileItem item : items) {
    if (item.isFormField()) {  //als het een veld is dan dit, anders File uploaden
        String fieldname = item.getFieldName();
        String fieldvalue = item.getString();
        switch (fieldname) {
            case "logicalName":
                LogicalName = fieldvalue;
                break;
            //other case statements...
        }
    } else {
        //here you only have to process the file
        File file;
        int maxFileSize = 500000 * 1024;//your comments...
        int maxMemSize = 5000 * 1024;//your comments...
        //this must be a constant or a servlet init param, do not hard code it
        String filePath = "C:\\uploads\\";
        String fileName = FilenameUtils.getName(item.getName());
        factory.setSizeThreshold(maxMemSize);
        //didn't you have a filePath variable?
        factory.setRepository(new File("c:\\temp"));
        upload.setSizeMax(maxFileSize);
        try {
            String fieldName = fi.getFieldName();
            boolean isInMemory = fi.isInMemory();
            long sizeInBytes = fi.getSize();
            file = new File(filePath, fileName);
            item.write(file);
            //code to save your file location in db...
            //note: this MUST BE in a business logic method, not directly written in your servlet
            HttpSession session = request.getSession();
            int uploader = (Integer) session.getAttribute("UserId");
        } catch (Exception ex) {
            //very BAD idea
            //use a logger instead like log4j or sfl4j
            System.out.println(ex);
        }
    }
}