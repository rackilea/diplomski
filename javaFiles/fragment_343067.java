import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;

public class NewClass {

    private int id;

    private String description;

    public static void main(String... a) throws JsonProcessingException {
        YAMLFactory f = new YAMLFactory();
        f.enable(YAMLGenerator.Feature.MINIMIZE_QUOTES);
        ObjectMapper objectMapperYaml = new ObjectMapper(f);

        final NewClass someObject = new NewClass();
        someObject.setId(4711);
        someObject.setDescription("Hallo\nWorld!");
        System.out.println(objectMapperYaml.writeValueAsString(someObject));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}