import java.io.File;
import java.io.IOException;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class WhichClass {

  private WhichClass() {
  }

  static Vector<String> scratchVector;

  public static void main(final String[] argv) {
    Vector v;

    if ((argv.length == 0) || "-all".equals(argv[0])) {
      v = findClass(null);
    } else {
      v = findClass(argv[0]);
    }

    for (int i = 0; i < v.size(); i++) {
      System.out.println(v.elementAt(i));
    }
  }

  static String className(final String classFile) {
    return classFile.replace('/', '.').substring(0, classFile.length() - ".class".length());
  }

  static Vector findClass(final String className) {
    if (className != null) {
      scratchVector = new Vector<String>(5);
    } else {
      scratchVector = new Vector<String>(5000);
    }

    findClassInPath(className, setupBootClassPath());
    findClassInPath(className, setupClassPath());

    return scratchVector;
  }

  static void findClassInPath(final String className, final StringTokenizer path) {
    while (path.hasMoreTokens()) {
      String pathElement = path.nextToken();

      File pathFile = new File(pathElement);

      if (pathFile.isDirectory()) {
        try {
          if (className != null) {
            String pathName = className.replace('.', System.getProperty("file.separator").charAt(0)) + ".class";

            findClassInPathElement(pathName, pathElement, pathFile);
          } else {
            findClassInPathElement(className, pathElement, pathFile);
          }
        } catch (IOException e) {
          e.printStackTrace();
        }
      } else if (pathFile.exists()) {
        try {
          if (className != null) {
            String pathName = className.replace('.', '/') + ".class";

            ZipFile  zipFile  = new ZipFile(pathFile);
            ZipEntry zipEntry = zipFile.getEntry(pathName);
            if (zipEntry != null) {
              scratchVector.addElement(pathFile + "(" + zipEntry + ")");
            }
          } else {
            ZipFile     zipFile = new ZipFile(pathFile);
            Enumeration entries = zipFile.entries();

            while (entries.hasMoreElements()) {
              String entry = entries.nextElement().toString();

              if (entry.endsWith(".class")) {
                String name = className(entry);

                scratchVector.addElement(pathFile + "(" + entry + ")");
              }
            }
          }
        } catch (IOException e) {
          System.err.println(e + " while working on " + pathFile);
        }
      }
    }
  }

  static void findClassInPathElement(final String pathName, final String pathElement, final File pathFile)
    throws IOException {
    String[] list = pathFile.list();

    for (int i = 0; i < list.length; i++) {
      File file = new File(pathFile, list[i]);

      if (file.isDirectory()) {
        findClassInPathElement(pathName, pathElement, file);
      } else if (file.exists() && (file.length() != 0) && list[i].endsWith(".class")) {
        String classFile = file.toString().substring(pathElement.length() + 1);

        String name = className(classFile);

        if (pathName != null) {
          if (classFile.equals(pathName)) {
            scratchVector.addElement(file.toString());
          }
        } else {
          scratchVector.addElement(file.toString());
        }
      }
    }
  }

  static StringTokenizer setupBootClassPath() {
    String classPath = System.getProperty("sun.boot.class.path");
    String separator = System.getProperty("path.separator");

    return new StringTokenizer(classPath, separator);
  }

  static StringTokenizer setupClassPath() {
    String classPath = System.getProperty("java.class.path");
    String separator = System.getProperty("path.separator");

    return new StringTokenizer(classPath, separator);
  }
}