public static boolean copyFile(String fileSource, String fileDestination)
{
    FileInputStream srcStream=null;
    FileOutputStream dstStream=null;
    try {
      srcStream = new FileInputStream(fileSource); 
      dstStream = new FileOutputStream(fileDestination)
      dstStream.getChannel().transferFrom(srcStream.getChannel(), 0, srcStream.getChannel().size());
        return true;
    }
    catch (IOException e)
    {
        return false;
    } finally {
      try { srcStream.close(); } catch (Exception e) {}
      try { dstStream.close(); } catch (Exception e) {}
    }
}