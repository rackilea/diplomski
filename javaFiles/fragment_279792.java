public class ImageFileFilter implements FileFilter
    {
      private final String[] okFileExtensions = 
        new String[] {"jpg", "png", "gif"};

      public boolean accept(File file)
      {
        for (String extension : okFileExtensions)
        {
          if (file.getName().toLowerCase().endsWith(extension))
          {
            return true;
          }
        }
        return false;
      }
    }