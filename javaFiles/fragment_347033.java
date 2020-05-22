package stackoverflow.questions.q19912055;

import java.lang.reflect.Type;
import java.util.*;

import stackoverflow.questions.q17853533.*;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class Q19912055 {

    class Region {
        String id;
        String name;
        String color;
        Integer hasResorts;
        @Override
        public String toString() {
            return "Region [id=" + id + ", name=" + name + ", color=" + color
                    + ", hasResorts=" + hasResorts + "]";
        }


    }

    static class RegionDeserializer implements JsonDeserializer<List<Region>> {
        public List<Region> deserialize(JsonElement json, Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {

            if (json == null)
                return null;
            ArrayList<Region> al = new ArrayList<Region>();
            for (JsonElement e : json.getAsJsonArray()) {

                boolean deserialize = e.getAsJsonObject().get("hasResorts")
                        .getAsInt() > 0;
                if (deserialize)
                    al.add((Region) context.deserialize(e, Region.class));
            }

            return al;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String json = 
            "  [                                   "+
            "        {                                            "+
            "            \"id\": \"69\",                          "+
            "            \"name\": \"North Carolina Coast\",      "+
            "            \"color\": \"#01162c\",                  "+
            "            \"hasResorts\": 1                        "+
            "        },                                           "+
            "        {                                            "+
            "            \"id\": \"242\",                         "+
            "            \"name\": \"North Carolina Inland\",     "+
            "            \"color\": \"#01162c\",                  "+
            "            \"hasResorts\": 0                        "+
            "        },                                           "+
            "        {                                            "+
            "            \"id\": \"17\",                          "+
            "            \"name\": \"North Carolina Mountains\",  "+
            "            \"color\": \"#01162c\",                  "+
            "            \"hasResorts\": 1                        "+
            "        },                                           "+
            "        {                                            "+
            "            \"id\": \"126\",                         "+
            "            \"name\": \"Outer Banks\",               "+
            "            \"color\": \"#01162c\",                  "+
            "            \"hasResorts\": 1                        "+
            "        }                                            "+
            "    ]                                                ";




        Type listType = new TypeToken<ArrayList<Region>>() {}.getType();                                
        List<Region> allRegions = new Gson().fromJson(json, listType); 
        System.out.println(allRegions);

        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(listType, new RegionDeserializer());
        Gson gson2 = builder.create();

        List<Region> regionsHaveResort = gson2.fromJson(json, listType); 
        System.out.println(regionsHaveResort);

    }

}