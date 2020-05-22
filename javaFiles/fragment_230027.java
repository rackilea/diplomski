import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JsonApp {

    public static void main(String[] args) {
        List<Integer> ints = IntStream.range(1, 10).boxed().collect(Collectors.toList());
        JsonArrayExt array = new JsonArrayExt(ints);

        JsonArray array1 = array.subList(2, 5);
        System.out.println(array);
        System.out.println(array1);
    }
}

class JsonArrayExt {
    private final JsonArray array;

    public JsonArrayExt(List<Integer> ints) {
        this(Json.createArrayBuilder(ints).build());
    }

    public JsonArrayExt(JsonArray array) {
        this.array = Objects.requireNonNull(array);
    }

    public JsonArray subList(int fromIndex, int toIndex) {
        JsonArrayBuilder builder = Json.createArrayBuilder();
        array.subList(fromIndex, toIndex).forEach(builder::add);

        return builder.build();
    }

    @Override
    public String toString() {
        return array.toString();
    }
}