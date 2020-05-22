import java.io.File;
import java.io.IOException;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;


public class Main {

 public static void main(String args[]){
 Wini ini;
 try {
  ini = new Wini(new File("config/settings.ini"));
  ini.put("main", "window-color", 000000);
  ini.put("main", "splash", false);
  ini.store();
 } catch (InvalidFileFormatException e) {
  System.out.println("Invalid file format.");
 } catch (IOException e) {
  System.out.println("Problem reading file.");
 }

 }