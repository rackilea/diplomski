public static boolean FileTypeAccept(File source, String[] fileTypes) 
{
    for (String filetype : fileTypes)
        if (source.getAbsolutePath().endsWith("." + filetype))
            return true;

    return false;
}