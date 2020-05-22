import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class FileLister {

  public static void main(String[] args) throws IOException {
    Path p = Paths.get("D:\\");

    Iterator<Path> it = Files.newDirectoryStream(p).iterator();
    DirectoryTreeIterator dti = new DirectoryTreeIterator(it);
    while (dti.hasNext()) {
      Path path = dti.next();
      if (!Files.isDirectory(path)) {
        String mime = Files.probeContentType(path);
        System.out.println("Mime of File "
                + path.getFileName() + " is: " + mime);
      }
    }
  }
}