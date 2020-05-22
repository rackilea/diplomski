protected MultiPartFormData handleMultiPartRequest(HttpServletRequest request)
throws FileSizeLimitExceededException
{
    if(!isMultipartRequest(request))
        return null;

    ServletFileUpload upload = FileUploader.getservletFileUploader(tempDir, 50);
    MultiPartFormData data = new MultiPartFormData();
    try
    {
        List<FileItem> items = upload.parseRequest(request);

        for (FileItem item : items) 
        {
            if(item.isFormField())
            {
                data.getParameters().put(item.getFieldName(), item.getString());
            }
            else
            {
                String filename = item.getName();

                //Internet explorer and firefox will send the file name differently
                //Internet explorer will send the entire path to the file name including 
                //the backslash characters etc ... we should strip it down
                //THIS IS HACKY
                if(filename.indexOf("\\") != -1)
                {
                    int index = filename.lastIndexOf("\\");
                    filename = filename.substring(index + 1);
                }


                if(filename == null || filename.equals(""))
                {
                    //do nothing 
                }
                else
                {
                    File uploadFile = new File(uploadDir + File.separator + randomFileName);
                    item.write(uploadFile);

                                            data.addFile(item.getFieldname(), item.getString());
                }
            }
        }
    }
    catch(FileSizeLimitExceededException e)
    {
        throw e;
    }
    catch(Exception e)
    {
        e.printStackTrace();

    }


    return data;
}