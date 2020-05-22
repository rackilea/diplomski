@Root
public class FileSet {

   @ElementList(entry="include", inline=true)
   private List<Match> include;

   @ElementList(entry="exclude", inline=true)
   private List<Match> exclude;

   @Attribute
   private File path;

   private List<File> files;

   public FileSet() {
      this.files = new ArrayList<File>();
   }

   @Commit
   public void commit() {
      scan(path);
   }

   private void scan(File path) { 
      File[] list = path.listFiles();

      for(File file : list) {
         if(file.isDirectory()) {
            scan(path);
         } else {            
            if(matches(file)) {
               files.add(file);
            }
         }
      }
   }

   private boolean matches(File file) {
      for(Match match : exclude) {
         if(match.matches(file)) {
            return false;
         }
      }
      for(Match match : include) {
         if(match.matches(file)) {
            return true;
         }
      }
      return false;
   }

   public List<File> getFiles() {
      return files;
   }

   @Root
   private static class Match {

      @Attribute            
      private String pattern;            

      public boolean matches(File file) {
         Stirng path = file.getPath();

         if(!file.isFile()) {
            return false;
         }
         return path.matches(pattern);         
      }         
   }
}