private void downloadDocument()
{
    final String retrievalName = "222.pdf";

    class FileDownloadResource extends FileResource
    {
        public FileDownloadResource(File sourceFile, Application application)
        {
            super(sourceFile, application);
        }

        public DownloadStream getStream()
        {
            try
            {
                byte[] DocContent = null;
                DocContent = getFileBytes("C:\\Temp\\222.pdf");
                if (DocContent != null)
                {
                    final DownloadStream ds = new DownloadStream(new ByteArrayInputStream(DocContent), "application/pdf", retrievalName);
                    ds.setCacheTime(getCacheTime());
                    String fileName = URLEncoder.encode(retrievalName, "UTF8");
                    // force download!
                    ds.setParameter("Content-Disposition", "attachment; filename*=\"utf-8'" + fileName + "\"");
                    return ds;
                }
                else
                {
                    return null;
                }
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
                return null;
            }
        }
    }
    getApplication().getMainWindow().open(new FileDownloadResource(new File(retrievalName), getApplication()));
}


/**
 * getFileBytes
 * 
 * @author NBochkarev
 * 
 * @param fileOut
 * @return
 * @throws IOException
 */
public static byte[] getFileBytes(String fileName) throws IOException
{
    ByteArrayOutputStream ous = null;
    InputStream ios = null;
    try
    {
        byte[] buffer = new byte[4096];
        ous = new ByteArrayOutputStream();
        ios = new FileInputStream(new File(fileName));
        int read = 0;
        while ((read = ios.read(buffer)) != -1)
            ous.write(buffer, 0, read);
    }
    finally
    {
        try
        {
            if (ous != null)
                ous.close();
        }
        catch (IOException e)
        {
            // swallow, since not that important
        }
        try
        {
            if (ios != null)
                ios.close();
        }
        catch (IOException e)
        {
            // swallow, since not that important
        }
    }
    return ous.toByteArray();
}