public class Filter implements FilenameFilter {
 String name; 

 public Filter(String name) {
    this.name = name; 

 }
 @Override
 public boolean accept(File dir, String filename) {
    //If you want to perform a case-insensitive search
    return filename.toLowerCase().contains(name.toLowerCase());
 }
}