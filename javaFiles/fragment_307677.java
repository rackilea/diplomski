package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties; 
public class PropertiesFile {

public static void main(String[] args){
   // readPropertiesFile();
}

private java.util.Properties prop=null;

public void readPropertiesFile(){
    prop = new Properties();
    try {


        InputStream input = new 
FileInputStream("C:\\Users\\chetan.patel\\git\\uvavoices-
automation\\config.properties");
        prop.load(input);
        System.out.println(prop.getProperty("url"));
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));


    } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }
public String getPropertyValue(String key){
    return prop.getProperty(key);
 }

}