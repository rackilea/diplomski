import java.io.*;

class Main {
    public static void main(String[] args) {
        File dir = new File("C:"); //file directory
        FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith("1203103"); //here is you file name starts with. Or you can use name.equals("1203103.txt");
            }
        };
     String[] children = dir.list(filter);
     if (children == null) {
         System.out.println("Either dir does not exist or is not a directory");
     }else {
         for (int i=0; i < children.length; i++) {
             String filename = children[i];
             System.out.println(filename);
         }
     } 
   }
}