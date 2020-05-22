import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class FileInformationMain {

   public static void main(String[] args) {

       System.out.println("File System Roots returned by File.listRoots(): ");
       System.out.println();
       File[] f = File.listRoots();

       Set<String> parents = new HashSet<String>();
       for (int i = 0; i < f.length; i++) {
           System.out.println("Drive: " + f[i]);
           System.out.println();
           System.out.println("List of lowest level parent directories: ");
           File[] files = f[i].listFiles();
           if (files != null) {
               for (File file : files) {
                   getFileNames(file, parents);
               }
           }
       }
       for (String string : parents)
           System.out.println(string);
   }

   public static void getFileNames(File aFile, Set<String> parents) {
       if (!aFile.isDirectory()) {
           parents.add(aFile.getParent());
       } else {
           File[] children = aFile.listFiles();
           if (children != null) {
               for (int x = 0; x < children.length; x++) {
                   getFileNames(children[x], parents);
               }
           }
       }
   }
}