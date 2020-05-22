public final class Q42210761 {

    private Q42210761() {
    }

    private static final Type fooBarObservableListType = new TypeToken<ObservableList<FooBar>>() {
    }.getType();

    private static final Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(ObservableStringValue.class, getObservableStringValueTypeAdapter())
            .registerTypeAdapterFactory(getObservableListTypeAdapterFactory())
            .create();

    public static void main(final String... args) {
        final ObservableList<FooBar> source = observableArrayList(
                new FooBar("foo-1", "bar-1"),
                new FooBar("foo-2", "bar-2"),
                new FooBar("foo-3", "bar-3")
        );
        out.println(source);
        final String json = gson.toJson(source, fooBarObservableListType);
        out.println(json);
        final ObservableList<?> destination = gson.fromJson(json, fooBarObservableListType);
        out.println(destination);
    }

}