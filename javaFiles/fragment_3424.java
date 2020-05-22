import java.io.IOException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PolymorphicDeserialize {
    public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();

        Dto type1 = mapper.readValue(getType1Json(), Dto.class);
        Dto type2 = mapper.readValue(getType2Json(), Dto.class);

        printDto(type1);
        printDto(type2);
    }

    private static void printDto(Dto dto) {
        System.out.println("type :" + dto.type);
        for (Config config : dto.configs) {
            System.out.println("itemLevel:" + config.itemLevel);
            System.out.println("powers:" + config.powers);
        }
    }

    private static String getType1Json() {

        return "   {                                                       "
                + "        \"type\": \"first_type\",                       "
                + "        \"configs\": [                                  "
                + "          {                                             "
                + "            \"itemLevel\": 1,                           "
                + "            \"power\": {                                "
                + "              \"firstTypeParam\": \"xxxx\"              "
                + "            }                                           "
                + "          },                                            "
                + "          {                                             "
                + "            \"itemLevel\": 2,                           "
                + "            \"power\": {                                "
                + "              \"firstTypeParam\": \"yyy\"               "
                + "            }                                           "
                + "          }                                             "
                + "        ]                                               "
                + "      }                                                 ";

    }

    private static String getType2Json() {

        return "   {                                                       "
                + "        \"type\": \"second_type\",                      "
                + "        \"configs\": [                                  "
                + "          {                                             "
                + "            \"itemLevel\": 11,                          "
                + "            \"power\": {                                "
                + "              \"anotherParam\": true                    "
                + "            }                                           "
                + "          },                                            "
                + "          {                                             "
                + "            \"itemLevel\": 12,                          "
                + "            \"power\": {                                "
                + "              \"anotherParam\": false                   "
                + "            }                                           "
                + "          }                                             "
                + "        ]                                               "
                + "      }                                                 ";

    }
}