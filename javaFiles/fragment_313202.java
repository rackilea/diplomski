import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
* Class that loads settings from config.properties
* @author Brant Unger
*
*/
public class Settings 
{
public static boolean DEBUG = false; 

/**
 * Load settings from config.properties
 */
public static void load()
{
    try
    {
        Properties appSettings = new Properties();
        FileInputStream fis = new FileInputStream("config.properties"); //put config properties file to buffer
        appSettings.load(fis); //load config.properties file

                   //This is where you add your config variables:
                   DEBUG = Boolean.parseBoolean((String)appSettings.get("DEBUG"));

        fis.close();
        if(DEBUG) System.out.println("Settings file successfuly loaded");

    }
    catch(IOException e)
    {
        System.out.println("Could not load settings file.");
        System.out.println(e.getMessage());
    }
}