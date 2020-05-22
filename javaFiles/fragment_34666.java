import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        List<Cluster> clusters = readClusters(jsonFile);
        clusters.forEach(System.out::println);
    }

    private static List<Cluster> readClusters(File jsonFile) throws IOException {
        Gson gson = new GsonBuilder().create();

        try (Stream<String> lines = Files.lines(jsonFile.toPath())) {
            return lines
                    .map(line -> gson.fromJson(line, Cluster.class))
                    .collect(Collectors.toList());
        }
    }
}

class ArrayAsStringJsonDeserializer implements JsonDeserializer<List<String>> {
    @Override
    public List<String> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String value = json.getAsString().trim();
        value = value.substring(1, value.length() - 1);

        return Arrays.stream(value.split(",")).map(String::trim).collect(Collectors.toList());
    }
}

@Data
@ToString
class Cluster {
    protected long id;
    protected long size;

    @SerializedName("cluster_size_in_offers")
    protected long clusterSizeInOffers;

    @JsonAdapter(ArrayAsStringJsonDeserializer.class)
    @SerializedName("id_values")
    protected List<String> idValues;

    @SerializedName("categoryDensity")
    protected int catDensity;

    @SerializedName("category")
    protected String cat;
}