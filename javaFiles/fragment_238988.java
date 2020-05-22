import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Test {

    private static final String JSON = "{ \"laofuthetiger\": {" + "\"id\": 51044840,"
            + "\"name\": \"Lao Fu the Tiger\"," + "\"profileIconId\": 664," + "\"revisionDate\": 1484537981000, "
            + "\"summonerLevel\": 30" + "}}";

    public static void main(String[] args) throws IOException {
        JsonParser parser = new JsonParser();
        Map.Entry<String, JsonElement> e = ((JsonObject) parser.parse(JSON)).entrySet().iterator().next();
        Gson g = new Gson();
        SummonerDto dto = g.fromJson(e.getValue(), SummonerDto.class);

        System.out.println(dto);
        }

    class SummonerDto {
        int id;
        String name;
        int profileIconId;
        long revisionDate;
        int summonerLevel;

        @Override
        public String toString() {
            return "SummonerDto [id=" + id + ", name=" + name + ", profileIconId=" + profileIconId + ", revisionDate="
                    + revisionDate + ", summonerLevel=" + summonerLevel + "]";
        }

    }