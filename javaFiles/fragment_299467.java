import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class JsonTest {


    static String config = "{contact:{\"FIRSTNAME\":\"C_FirstName\",\"EMAIL\":\"C_EmailAddress\"}, "
                          + "customobject:{\"CUSTOM_FIELD1\":\"Custom_Field__11\","
                          + "\"FIRSTNAME\":\"First_Name1\",\"EMAIL\":\"Email_Address1\"}}";

    String contact = "{\"FIRSTNAME\":\"C_FirstName\",\"EMAIL\":\"C_EmailAddress\"}";
    String customobject = "{\"CUSTOM_FIELD1\":\"Custom_Field__11\","
                          + "\"FIRSTNAME\":\"First_Name1\",\"EMAIL\":\"Email_Address1\"}";

    public static void main(String[] args) {

        Gson gson = new Gson();

        Conf c = gson.fromJson(config, Conf.class);

        String contactStr = gson.toJson(c.getContact());

        System.out.println(contactStr);

    }

    class Conf{

        Map<String, String> contact;
        Map<String, String> co;
        public Map<String, String> getContact() {
            return contact;
        }
        public void setContact(Map<String, String> contact) {
            this.contact = contact;
        }
        public Map<String, String> getCo() {
            return co;
        }
        public void setCo(Map<String, String> co) {
            this.co = co;
        }


    }
}