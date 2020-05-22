/**
 * Retrieve a File representation of the folder this application is
 * located in.
 * 
 * @return
 */
private static File getApplicationRootFolder()
{
    String path = FileGetter.class.getProtectionDomain().getCodeSource()
            .getLocation().getPath();
    try
    {
        String decodedPath = URLDecoder.decode(path, "UTF-8");
        File jarParentFolder = new File(decodedPath).getParentFile();
        if (jarParentFolder.exists() && jarParentFolder.canRead()
        {
            File shellScript = new File(jarParentFolder, "import.sh")
    }
    catch (UnsupportedEncodingException e)
    {
        Main.myLog.error(TAG, "Unencoding jar path failed on:\n\t" + path);
        e.printStackTrace();
        return null;
    }
}