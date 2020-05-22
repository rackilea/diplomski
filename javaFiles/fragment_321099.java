public class MySuperDuperTextClass {
   private File file = null;
   private String content = null;
   public File getFile() { return file; }
   public void setFile( File file ) { this.file = file; }
   public String getContent() { return content; }
   public void setContent( String content ) { this.content = content; }

public MySuperDuperTextClass( String filename ){
  try {
    File file = new File ( filename );
    if (!file.exists()){ 
        file.createNewFile(); 
    }
      PrintWriter pw = new PrintWriter(file);
      pw.println("this is my file content");
      pw.close();
      System.out.println("hi");
    } catch (IOException ex) {
        Logger.getLogger(RST.class.getName()).log(Level.SEVERE, null, ex);
    }
   // somewhere you may want to store the content of the file into
   // the this.content file:
   this.content = new 
       String(java.nio.file.Files.readAllBytes(Paths.get(filename))); 
}