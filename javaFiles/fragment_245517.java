import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        AddLabel label = new AddLabel("A label");
        label.getLabels().add(AddLabel.Label.remove("Remove"));
        label.getLabels().add(AddLabel.Label.set("Set"));

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        System.out.println(mapper.writeValueAsString(label));
    }
}

@JsonRootName(value = "update")
class AddLabel {

    @JsonProperty("labels")
    private List<Label> labels;

    public AddLabel(String labelName) {
        this.labels = new ArrayList<>();
        this.labels.add(Label.add(labelName));
    }

    public List<Label> getLabels() {
        return labels;
    }

    public static class Label {

        private final String key;
        private final String value;

        private Label(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public static Label add(String value) {
            return new Label("add", value);
        }

        public static Label remove(String value) {
            return new Label("remove", value);
        }

        public static Label set(String value) {
            return new Label("set", value);
        }

        @JsonAnyGetter
        public Map<String, String> getDynamic() {
            return Collections.singletonMap(key, value);
        }
    }
}