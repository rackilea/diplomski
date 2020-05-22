import java.util.Map; 

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

JsonParser parser = new JsonParser();
//e.getKey() is actual 'category' name
//e.getValue() is raw JsonObject
Map.Entry<String, JsonElement> e = ((JsonObject)parser.parse(jsonString)).entrySet().iterator().next();
Gson g = new Gson();
SummonerDto dto = g.fromJson(e.getValue(), SummonerDto.class);