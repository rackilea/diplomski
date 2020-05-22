public interface OS {
     void openFile(java.io.File file) throws java.io.IOException;
 }

 public class OSFactory {
     public static OS create(){
         try{
             Class.forName("java.awt.Desktop");
             return new OSJ6();
         }catch(Exception e){
             //fall back
             return new OSJ5();
         }
     }
 }