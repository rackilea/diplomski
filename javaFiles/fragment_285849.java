import org.json.*;
    public class JSonParsing {
        public static void main(String[] args){
            String source = "{\n" +
    "  \"head\": {\n" +
    "    \"vars\": [ \"author\" , \"title\" , \"paper\" , \"fulltext\" ]\n" +
    "  } ,\n" +
    "  \"results\": {\n" +
    "    \"bindings\": [\n" +
    "      {\n" +
    "        \"author\": { \"type\": \"uri\" , \"value\": \"http://data.linkededucation.org/resource/lak/person/richard-scheines\" } ,\n" +
    "        \"title\": { \"type\": \"literal\" , \"value\": \"Discovering Prerequisite Relationships among Knowledge Components\" } ,\n" +
    "        \"paper\": { \"type\": \"uri\" , \"value\": \"http://data.linkededucation.org/resource/lak/conference/edm2014/paper/492\" } ,\n" +
    "        \"fulltext\": { \"type\": \"literal\" , \"value\": \"GET TEXT\" }\n" +
    "      }\n" +
    "    ]\n" +
    "  }\n" +
    "}\n" +
    "";
            JSONObject main = new JSONObject(source);
            JSONObject results = main.getJSONObject("results");
            JSONArray bindings = results.getJSONArray("bindings");
            JSONObject firstObject = bindings.getJSONObject(0);
            JSONObject fulltextOfFirstObject = firstObject.getJSONObject("fulltext");
            String type = fulltextOfFirstObject.getString("type");
            String value = fulltextOfFirstObject.getString("value");
            System.out.println("Type :"+ type+"\nValue :"+value);
        }
    }