protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
    InputStream fileContent = null;
    String user = "";
    for (FileItem item : items) 
    {
        if (item.isFormField()) 
        {
            String fieldName = item.getFieldName();
            String fieldValue = item.getString();
            if(fieldName.equalsIgnoreCase("user"))
            {
                user = fieldValue;
            }
        }
        else 
        {
            String fieldName = item.getFieldName();
            if(fieldName.equalsIgnoreCase("image"))
            {
                fileContent = item.getInputStream();
            } 
        }
    }
}