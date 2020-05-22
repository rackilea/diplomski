// JNA Demo. Scriptol.com
package CInterface; 
import com.sun.jna.Library; 
import com.sun.jna.Native;
import com.sun.jna.Platform;

public class hello 
{ 
  public static void main(String[] args) 
  { 
    String mytext = "Hello World!";  
     if (args.length != 1) 
    { 
      System.err.println("You can enter your own text between quotes..."); 
      System.err.println("Syntax: java -jar /jna/dist/demo.jar \"myowntext\"");
    }
    else
       mytext = args[0]; 

    // Library is c for unix and msvcrt for windows
    String libName = "c"; 
    if (System.getProperty("os.name").contains("Windows")) 
    { 
      libName = "msvcrt";  
    } 

    // Loading dynamically the library
    CInterface demo = (CInterface) Native.loadLibrary(libName, CInterface.class); 
    demo.puts(mytext);
  } 
}