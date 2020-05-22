import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class App 
{
static String data = "{ \"data\" : [\r\n" + 
        "    {   \"ID\":\"3b071d17-bfe5-4474-a7b4-58c755c7d954\",\r\n" + 
        "        \"value\":\"328.0\"},\r\n" + 
        "    {   \"ID\":\"dc4607f9-5955-4dd8-8c1a-abd3719edb6f\",\r\n" + 
        "        \"value\":\"764.1\"},\r\n" + 
        "    {   \"ID\":\"a4aa9f3b-599f-4815-5776-20fa38b064b5\",\r\n" + 
        "        \"value\":\"983.6\"},\r\n" + 
        "    {   \"ID\":\"c6fb7cd8-381d-93fa-711b-9482ab394ffa\",\r\n" + 
        "        \"value\":\"351.5\"},\r\n" + 
        "    {   \"ID\":\"2366a36b-8df2-72db-40bc-bbbe3258f09c\",\r\n" + 
        "        \"value\":\"539.3\"}\r\n" + 
        "]}";

public static void main(String... args){
    JsonParser jsonParser = new JsonParser();
    JsonObject objectFromString = jsonParser.parse(data).getAsJsonObject();
    JsonArray dataArray= objectFromString.getAsJsonArray("data");
    //here will get data from the start ID to end ID

    Set<Entry<String, Float>> dataMap = convertJsonArrayToMap(dataArray);
    String startId = "dc4607f9-5955-4dd8-8c1a-abd3719edb6f";
    String endId = "c6fb7cd8-381d-93fa-711b-9482ab394ffa";

    List<Float> dataSave = getValueBasedOnRange(startId, endId,dataMap);
    System.out.println(dataSave.toString());
}
//Generate and return the map from the JsonArray parameter
private static Set<Entry<String, Float>> convertJsonArrayToMap(JsonArray dataArray){
    Map<String,Float> dataMap = new LinkedHashMap<>();
    for (JsonElement currentElement : dataArray) {

        JsonObject currentJsonObject = currentElement.getAsJsonObject();
        dataMap.put(currentJsonObject.get("ID").getAsString(), currentJsonObject.get("value").getAsFloat());
    }
    return dataMap.entrySet();
}
//Generate and return the List<Float> from the map parameter
//Save the float value of the object with ID=startId
//Save the float value of the ANY object after startID
//Save the float value of the object with ID=endId and return
private static List<Float> getValueBasedOnRange(String startId, String endId, Set<Entry<String, Float>> dataMap){
    boolean collectFlag = false;
    List<Float> dataSave = new ArrayList<>();

    for(Entry<String, Float> mapEntry : dataMap) {
        if(startId.equals(mapEntry.getKey())) {
            collectFlag = true;
        }

        if(collectFlag) {
            dataSave.add(mapEntry.getValue());
        }

        if(endId.equals(mapEntry.getKey())) {
            return dataSave;
        }
    }
    return dataSave;
}