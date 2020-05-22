import java.io.File;
import java.io.FilenameFilter;

public class DirScan
{
    public static void main(String[] args)
    {
        File root = new File("C:\\");
        FilenameFilter beginswithm = new FilenameFilter()
        {
         public boolean accept(File directory, String filename) {
              return filename.startsWith("M");
          }
        };

        File[] files = root.listFiles(beginswithm);
        for (File f: files)
        {
            System.out.println(f);
        }
    }
}