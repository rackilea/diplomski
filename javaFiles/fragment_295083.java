private static final Gson gson = new GsonBuilder()
        .disableHtmlEscaping()
        .registerTypeAdapterFactory(classKeyMultimapTypeAdapterFactory())
        .create();

public static void main(final String... args) {
    final Multimap<Class<?>, Object> multimapBefore = ImmutableMultimap.<Class<?>, Object>builder()
            .put(int.class, 2)
            .put(int.class, 3)
            .put(int.class, 4)
            .put(Integer.class, 2)
            .put(Integer.class, 3)
            .put(Integer.class, 4)
            .put(String.class, "foo")
            .put(String.class, "bar")
            .put(String.class, "baz")
            .build();
    System.out.println(multimapBefore);
    final String json = gson.toJson(multimapBefore, classKeyMultimapType);
    System.out.println(json);
    final Multimap<Class<?>, Object> multimapAfter = gson.fromJson(json, classKeyMultimapType);
    System.out.println(multimapAfter);
    if ( !multimapBefore.equals(multimapAfter) ) {
        throw new AssertionError("multimaps do not equal");
    }
}