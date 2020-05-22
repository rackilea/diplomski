package stackoverflow.questions.q23556772;

import java.util.*;

import com.google.gson.*;

public class Q23556772 {

    public static class Class1 {
        String code;
        String request_id;
        Boolean ok;
        HashMap<String, Integer> payload_meta;

        @Override
        public String toString() {
            return "Class1 [code=" + code + ", request_id=" + request_id + ", ok=" + ok + ", payload_meta=" + payload_meta + "]";
        }

    }

    public static class Class2 {
        String id;
        String duration;
        Integer duration_seconds;
        Integer size_bytes;

        @Override
        public String toString() {
            return "Class2 [id=" + id + ", duration=" + duration + ", duration_seconds=" + duration_seconds + ", size_bytes=" + size_bytes + "]";
        }

    }


    public static void main(String[] args) {
     String json = 
             "[{                                                     "+
             "  \"code\": 200,                                       "+
             "  \"request_id\": \"52d868df5ada23e5f289320f\",        "+
             "  \"ok\": true,                                        "+
             "  \"payload_meta\": {                                  "+
             "    \"original_size\": 1837,                           "+
             "    \"size\": 1837                                     "+
             "  }                                                    "+
             "},{                                                    "+
             "  \"id\": \"4fb56d7f273fb7ebfe22783f\",                "+
             "  \"duration\": \"6:49\",                              "+
             "  \"duration_seconds\": 409,                           "+
             "  \"size_bytes\": 16396948                             "+
             "},{                                                    "+
             "  \"id\": \"4fb56d7f273fb7ebfe227841\",                "+
             "  \"duration\": \"3:42\",                              "+
             "  \"duration_seconds\": 222,                           "+
             "  \"size_bytes\": 8904980                              "+
             "},{                                                    "+
             "  \"id\": \"4fb56d7f273fb7ebfe227846\",                "+
             "  \"duration\": \"4:06\",                              "+
             "  \"duration_seconds\": 246,                           "+
             "  \"size_bytes\": 9843339                              "+
             "}]                                                     ";



     ArrayList<Object> result = new ArrayList<>();

     Gson g = new Gson();

     JsonArray e = new JsonParser().parse(json).getAsJsonArray();

     for(int i = 0; i < e.size(); i++){
         JsonObject o = e.get(i).getAsJsonObject();
         if (o.get("code") != null)
             result.add(g.fromJson(o, Class1.class));
         else if (o.get("id") != null)
             result.add(g.fromJson(o, Class2.class));
         else result.add(g.fromJson(o, Object.class));
     }

     for(Object resultObject: result)
         System.out.println(resultObject.toString());


    }

}