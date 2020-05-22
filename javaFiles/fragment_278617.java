import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

JSONParser parser_obj = new JSONParser();
JSONArray array_obj = (JSONArray) parser_obj.parse("String from web service"); 
// in your case it will be "result"