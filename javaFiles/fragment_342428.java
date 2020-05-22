import java.io.File;

public class Hidden{
   public static void main(String[] args){
      File dir = new File(args[0]);
      for (File file : dir.listFiles()){
         System.out.println(file + " is hidden? " + file.isHidden());
      }     
   }
}