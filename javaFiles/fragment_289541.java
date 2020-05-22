public class FileGetter
{

    private static String RESOURCE_DIRECTORY = "bin";

    /**
     * Retrieve an InputStream for a resource file.
     * 
     * @param filename
     * @return
     */
    public InputStream getResourceFileStream(String filename)
    {
        // this is where you decide your preference or the priority of the locations
        InputStream inputStream = null;

        inputStream = getExternalFile(filename);
        if (inputStream != null)
        {
            return inputStream;
        }
        inputStream = getInternalPackagedFile(filename);
        if (inputStream != null)
        {
            return inputStream;
        }
        inputStream = getInternalUnpackagedFile(filename);
        if (inputStream != null)
        {
            return inputStream;
        }

        // couldn't find the file anywhere so log some error or throw an exception
        return null;
    }

    /**
     * Retrieve an InputStream for a file located outside your Jar
     * 
     * @param filename
     * @return
     */
    private static InputStream getExternalFile(String filename)
    {
        // get the jar's absolute location on disk (regardless of current 'working directory')
        String appRootPath = FileGetter.class.getProtectionDomain().getCodeSource()
                .getLocation().getPath();
        try
        {
            String decodedPath = URLDecoder.decode(appRootPath, "UTF-8");
            File jarfile = new File(decodedPath);
            File parentDirectory = jarfile.getParentFile();
            if (testExists(parentDirectory))
            {
                File shellScript = new File(parentDirectory, filename);
                if (testExists(shellScript))
                {
                    return new FileInputStream(shellScript);
                }
            }
        }
        catch (UnsupportedEncodingException e)
        {}
        catch (NullPointerException e)
        {}
        catch (FileNotFoundException e)
        {}
        // if any part fails return null
        return null;
    }

    /**
     * Retrieve an InputStream for a file located inside your Jar.
     * 
     * @param filename
     * @return
     */
    private static InputStream getInternalPackagedFile(String filename)
    {
        // root directory is defined as the jar's root so we start with a "/".
        URL resUrl = FileGetter.class.getResource(File.separator + RESOURCE_DIRECTORY
                + File.separator + filename);
        String badPath = resUrl.getPath();
        String goodPath = badPath.substring(badPath.indexOf("!") + 1);
        InputStream input = FileGetter.class.getResourceAsStream(goodPath);
        // returns null if nothing there so just
        return input;
    }

    private static InputStream getInternalUnpackagedFile(String filename)
    {
        // eclipse will 'cd' to the code's directory so we use relative paths
        File shellScriptFile = new File(RESOURCE_DIRECTORY + File.separator + filename);
        if (testExists(shellScriptFile))
        {
            try
            {
                InputStream shellScriptStream = new FileInputStream(shellScriptFile);
                if (shellScriptStream != null)
                {
                    return shellScriptStream;
                }
            }
            catch (FileNotFoundException e)
            {}
        }
        return null;
    }

    /**
     * Test that a file exists and can be read.
     * 
     * @param file
     * @return
     */
    private static boolean testExists(File file)
    {
        return file != null && file.exists() && file.canRead();
    }
}