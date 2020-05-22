example:

 import java.io.File;
 import java.io.FilenameFilter;

 public class FileDemo 
 {
 public static void main(String[] args) {

  File f = null;
  File[] paths;

  try{      
     // create new file
     f = new File("c:/test");

     // create new filename filter
     FilenameFilter fileNameFilter = new FilenameFilter() {

        @Override
        public boolean accept(File dir, String name) {
           if(name.lastIndexOf('.')>0)
           {
              // get last index for '.' char
              int lastIndex = name.lastIndexOf('.');

              // get extension
              String str = name.substring(lastIndex);

              // match path name extension
              if(str.equals(".txt"))
              {
                 return true;
              }
           }
           return false;
        }
     };
     // returns pathnames for files and directory
     paths = f.listFiles(fileNameFilter);

     // for each pathname in pathname array
     for(File path:paths)
     {
        // prints file and directory paths
        System.out.println(path);
     }
    }catch(Exception e){
     // if any error occurs
     e.printStackTrace();
   }
  }
 }