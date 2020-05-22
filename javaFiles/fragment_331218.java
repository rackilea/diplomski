public class Article {

    public static Value create(Value v) {
        v.progress += "creating ";
        return v;
    }

    public static Value processing(Value v) {
        v.progress += "processing ";
        return v;
    }

    public static Value updating(Value v) {
        v.progress += "updating ";
        return v;
    }

    public static Value uploading(Value v) {
        v.progress += "uploading ";
        return v;
    }


    public static void main(String[] args) {
        Optional<Value> maybeValue = Stream.of(new Value())
                                           .map(Article::create)
                                           .map(Article::processing)
                                           .map(Article::updating)
                                           .map(Article::uploading)
                                           .findFirst();

        maybeValue.ifPresent(v -> System.out.println(v.progress));
    }
}