import java.io.*;
import java.util.Collection;
import java.util.zip.*;

import javax.swing.JPanel;

import org.apache.commons.io.*;
import org.apache.commons.io.filefilter.*;

public class Demo extends JPanel {
  private static final long serialVersionUID = 1L;

  public static void main(String s[]) throws Exception {
    Demo demo = new Demo();
    demo.launch();
  }

  private void launch() throws Exception {
    Collection<File> fs = FileUtils.listFilesAndDirs(new File("/tmp/fakerepo"),
        FileFileFilter.FILE, DirectoryFileFilter.DIRECTORY);
    ZipOutputStream zos = null;
    try {
      zos = new ZipOutputStream(new FileOutputStream("/tmp/test.zip"));
      for (File f : fs) {
        System.out.println(f.getAbsolutePath());
        if (!f.isFile())
          continue;
        ZipEntry ze = new ZipEntry(f.getAbsolutePath());
        zos.putNextEntry(ze);
        InputStream is = null;
        try {
          is = new FileInputStream(f);
          IOUtils.copy(is, zos);
        } finally {
          IOUtils.closeQuietly(is);
        }
      }
      zos.flush();
    } finally {
      IOUtils.closeQuietly(zos);
    }
  }

}