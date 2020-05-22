import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map map = mapper.readValue(
                    new File("C:\\Users\\<UserName>\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\Preferences"),
                    Map.class);
            Map devTools = (Map) map.get("devtools");
            Map preferences = (Map) devTools.get("preferences");
            String standardEmulatedDeviceList = (String) preferences.get("standardEmulatedDeviceList");
            List emulatorMap = mapper.readValue(standardEmulatedDeviceList, List.class);
            System.out.println(emulatorMap.size());
            for (Object object : emulatorMap) {
                Map device = (Map) object;
                System.out.println(device.get("title"));
            }
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}