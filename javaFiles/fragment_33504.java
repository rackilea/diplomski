import java.util.HashMap;
import java.util.Map;

public class JsonWrapper {
    public String plants = "flowers";
    Map<String, Flower> types = new HashMap<>();

    public Map<String, Flower> getTypes() {
        return types;
    }

    public void setTypes(Map<String, Flower> types) {
        this.types = types;
    }
}