public class Article {

    public Function<Value, Value> create() {
        return v -> {
            v.progress += "creating ";
            return v;
        };
    }

    public Function<Value, Value> processing() {
        return v -> {
            v.progress += "processing ";
            return v;
        };
    }

    public Function<Value, Value> updating() {
        return v -> {
            v.progress += "updating ";
            return v;
        };
    }

    public Function<Value, Value> uploading() {
        return v -> {
            v.progress += "uploading ";
            return v;
        };
    }

    public static void main(String[] args) {
        final Article a = new Article();
        final Value v = a.create()
                         .andThen(a.processing())
                         .andThen(a.updating())
                         .andThen(a.uploading())
                         .apply(new Value());

        System.out.println(v.progress);
    }
}