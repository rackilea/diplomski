public static boolean copyFile(String fileSource, String fileDestination)
{
    try(
      FileInputStream srcStream = new FileInputStream(fileSource); 
      FileOutputStream dstStream = new FileOutputStream(fileDestination) )
    {
        dstStream.getChannel().transferFrom(srcStream.getChannel(), 0, srcStream.getChannel().size());
        return true;
    }
    catch (IOException e)
    {
        return false;
    } 
}