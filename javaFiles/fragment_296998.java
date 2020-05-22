import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class JsonTest implements Serializable {
    @JsonIgnore
    private static JsonTest instance = null;

    private transient Set<String> set = new CopyOnWriteArraySet<String>();

    private JsonTest() {}

    @JsonIgnore
    public static JsonTest getInstance() {
        if (instance == null)
            instance = new JsonTest();
        return instance;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    @JsonIgnore
    public Set<String> getSet() {
        return set;
    }

    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        mapper.setVisibilityChecker(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
        try {
            return mapper.writeValueAsString(this);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<String>();
        set.add("test");
        JsonTest.getInstance().setSet(set);
        System.out.println(JsonTest.getInstance().toString());
    }
}