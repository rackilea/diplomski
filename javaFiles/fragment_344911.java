import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {

    public static void main(String[] args) {

        String VCAP_Services = "{\"userProvided\": [{\"credentials\": {\"accessTokenUri\": \"tokenurl\",\"apiUrl\": \"apiurl\",\"clientId\": \"typeofID\",\"clientSecret\": \"secretAf\",\"scope\": \"none\"},\"syslog_drain_url\": \"\",\"volume_mounts\": [],\"label\": \"user-provided\",\"name\": \"OAuth2\",\"tags\": []},{\"credentials\": {\"jdbcUrl\": \"jdbc:oracle:connection[host]:[port]/service\",\"spring.datasource.driver-class-name\": \"oracle.jdbc.OracleDriver\",\"spring.datasource.initialize\": \"false\"},\"syslog_drain_url\": \"\",\"volume_mounts\": [],\"label\": \"user-provided\",\"name\": \"Database\",\"tags\": [] } ] } ";

        CupsProperties properties=null;
        try {

            JSONParser jsonParser = new JSONParser();
            JSONObject vcapServiceJSONObject = (JSONObject) jsonParser.parse(VCAP_Services);

            for(Object key: vcapServiceJSONObject.keySet()){
                String keyStr = (String) key;
                JSONArray userProvidedList = (JSONArray) vcapServiceJSONObject.get(keyStr);

                Iterator i = userProvidedList.iterator();
                while (i.hasNext()) {
                    JSONObject innerObj = (JSONObject) i.next();
                    JSONObject credentialsObject = (JSONObject) innerObj.get("credentials");
                    if(credentialsObject.containsKey("jdbcUrl")){
                        //set to your pojo objects
                        System.out.println("JDBC url:" + credentialsObject.get("jdbcUrl"));
                    }

                    if(credentialsObject.containsKey("accessTokenUri")){
                        //set to your pojo objects
                        System.out.println("Access token URI:" + credentialsObject.get("accessTokenUri"));
                    }
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}