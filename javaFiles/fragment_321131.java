import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.omg.CORBA.ORB;

public class ReadProps {
    public static void main(String[] args) {
        ORB clientsORB = org.omg.CORBA.ORB.init(readConfigFile(), null);
    }

    static String[] readConfigFile() {
        Properties prop = new Properties();
        String[] orbarg = new String[2];

        try {
            // load a properties file
            prop.load(new FileInputStream("config.properties"));
            // get the property value and print it out  
            orbarg[0] = "-ORBInitRef"; // <---- NEEDED
            orbarg[1] = prop.getProperty("ORBInitRef");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return orbarg;
    }

}