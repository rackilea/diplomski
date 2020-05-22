import java.io.File;
import java.io.IOException;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;


public class Main {

 public static void main(String args[]){
  try{
   Wini ini;
   /* Load the ini file. */
   ini = new Wini(new File("config/settings.ini"));
   /* Extract the window color value.*/
   int windowColor = ini.get("main", "window-color", int.class);
   /* Extract the splash screen status. */
   boolean splashScreen = ini.get("main", "splash", boolean.class);

   /* Show to user the output. */
   System.out.println("Your default window color is: " + windowColor);
   if(splashScreen){
    System.out.println("You have your splash screen activated.");
   }else{
    System.out.println("You have your splash disabled.");
   }
  } catch (InvalidFileFormatException e) {
   System.out.println("Invalid file format.");
  } catch (IOException e) {
   System.out.println("Problem reading file.");
  }
 }

}