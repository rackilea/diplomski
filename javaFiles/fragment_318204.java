import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import java.util.Set;

public class JacksonTest {

    final static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws Exception {

        final String jsonInString = "{\n"
                + "    \"id\": 0,\n"
                + "    \"familyName\": \"someFN\",\n"
                + "    \"givenName\": \"someGivenName\",\n"
                + "    \"firstName\":\"firstNameInperson\",\n"
                + "    \"lastName\": \"\",\n"
                + "    \"middleName\": \"\",\n"
                + "    \"suffix\": \"\",    \n"
                + "    \"motherName\": \"\",\n"
                + "    \"alias\": [\n"
                + "        {\n"
                + "        \"firstName\": \"firstNameInAlias\",\n"
                + "        \"lastName\": \"\",\n"
                + "        \"middleName\": \"\",\n"
                + "        \"suffix\": \"\"\n"
                + "        }\n"
                + "    ]\n"
                + "}";
        //System.out.println(jsonInString);

        Person person = mapper.readValue(jsonInString, Person.class);
        System.out.println(person);
        // System.out.println(newFoo.getSomething());
    }
}

class Person {

    @JsonProperty
    private int id;

    @JsonProperty
    private String familyName;

    Alias alias;

    @JsonProperty
    private String motherName;
    @JsonProperty
    private Set<Alias> aliases;

    @JsonCreator
    public Person(final Map<String, Object> properties) {
        System.out.println("printing in constructor.." + properties);
        id = (Integer) properties.get("id");
        familyName = (String) properties.get("familyName");
        Alias al = new Alias();
        al.firstName = (String) properties.get("firstName");
        al.lastName = (String) properties.get("lastName");
        al.middleName = (String) properties.get("middleName");
        al.suffix = (String) properties.get("suffix");
        this.alias = al;
        TypeReference aliasesType = new TypeReference<Set<Alias>>() {
        };
        try {
            aliases = JacksonTest.mapper.readValue(JacksonTest.mapper.writeValueAsString(properties.get("alias")), aliasesType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String toString() {
        return "Person: familyName:" + familyName + ", Alias: " + alias + " Aliases:" + aliases;
    }

}

class Alias {

    @JsonProperty
    String firstName;

    @JsonProperty
    String lastName;

    @JsonProperty
    String middleName;

    @JsonProperty
    String suffix;

    public String toString() {
        return "Alias : firstName::" + firstName;
    }
}