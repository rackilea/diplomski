<%
String contentType = request.getContentType();
if ((contentType != null) && contentType.startsWith("multipart/form-data"))
{
    Part part = request.getPart("upload");
   ...