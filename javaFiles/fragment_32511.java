FileItemFactory factory = new DiskFileItemFactory();

// Set factory constraints
// factory.setSizeThreshold(yourMaxMemorySize);
// factory.setRepository(yourTempDirectory);

// Create a new file upload handler
ServletFileUpload upload = new ServletFileUpload( factory );
// upload.setSizeMax(yourMaxRequestSize);

// Parse the request
List<FileItem> uploadItems = upload.parseRequest( request );

for( FileItem uploadItem : uploadItems )
{
  if( uploadItem.isFormField() )
  {
    String fieldName = uploadItem.getFieldName();
    String value = uploadItem.getString();
  }
}