public class FileUploader 
{
private static ServletFileUpload uploader;

private FileUploader()
{

}

public static synchronized ServletFileUpload getservletFileUploader(String tempDir, int maxSizeInMB) 
{
    if(uploader == null)
    {
        DiskFileItemFactory factory = new DiskFileItemFactory();

        factory.setSizeThreshold(1024 * 1024);
        factory.setRepository(new File(tempDir));

        uploader = new ServletFileUpload(factory);

        uploader.setFileSizeMax(maxSizeInMB * 1024 * 1024);
    }

    return uploader;
}
}