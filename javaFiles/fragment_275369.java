import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.Collection;

public class GsonApp {

    private static final String TEST_JSON = "[\n" +
            "    {\n" +
            "        \"list buyed list\": [],\n" +
            "        \"list name\": \"item1\",\n" +
            "        \"list quantity\": \"Не купленных: 0\",\n" +
            "        \"list main list\": [\n" +
            "            {\n" +
            "                \"listelement quantity\": 4,\n" +
            "                \"listelement sum\": 1,\n" +
            "                \"listelement name\": \"item 1\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"listelement quantity\": 2,\n" +
            "                \"listelement sum\": 2,\n" +
            "                \"listelement name\": \"item 2\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"listelement quantity\": 4,\n" +
            "                \"listelement sum\": 3,\n" +
            "                \"listelement name\": \"item 3\"\n" +
            "            }\n" +
            "        ]\n" +
            "    },\n" +
            "    {\n" +
            "        \"list buyed list\": [],\n" +
            "        \"list name\": \"item2\",\n" +
            "        \"list quantity\": \"Не купленных: 0\",\n" +
            "        \"list main list\": [\n" +
            "            {\n" +
            "                \"listelement quantity\": 5,\n" +
            "                \"listelement sum\": 1,\n" +
            "                \"listelement name\": \"item 4\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"listelement quantity\": 4,\n" +
            "                \"listelement sum\": 7,\n" +
            "                \"listelement name\": \"item 5\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"listelement quantity\": 6,\n" +
            "                \"listelement sum\": 3,\n" +
            "                \"listelement name\": \"item 6\"\n" +
            "            }\n" +
            "        ]\n" +
            "    }\n" +
            "]";


    public static void main(String[] args) throws Exception {
        final Gson gson = new GsonBuilder().create();
        final Collection<RootItem> rootItems = gson.fromJson(TEST_JSON, new TypeToken<Collection<RootItem>>() {
        }.getType());
        System.out.println(rootItems);
    }
}