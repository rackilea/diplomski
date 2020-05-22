Http.MultipartFormData body = request().body().asMultipartFormData();
Http.MultipartFormData.FilePart resourceFile = body.getFile("jsonFile");

if( resourceFile != null )
{
    File uploadedFile = resourceFile.getFile();
}