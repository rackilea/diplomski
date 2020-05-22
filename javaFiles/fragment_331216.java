import java.util.function.Function;

public class Article {

    private final Function<Value, Value> create = v -> new Value(v.progress + "creating ");
    private final Function<Value, Value> processing = v -> new Value(v.progress + "processing ");
    private final Function<Value, Value> updating = v -> new Value(v.progress + "updating ");
    private final Function<Value, Value> uploading = v -> new Value(v.progress + "uploading ");

    public static void main(String[] args) {
        final Article a = new Article();
        final Value v = a.create.andThen(a.processing).andThen(a.updating).andThen(a.uploading).apply(new Value());

        System.out.println(v.progress);
    }
}