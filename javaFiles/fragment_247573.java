class GsonUtils {

    public static Gson getGson() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(RuntimeTypeAdapterFactory.of(BaseClass.class)
                        .registerSubtype(DerivedClass.class))
                .registerTypeAdapterFactory(new PostConstructAdapterFactory())
                .create();
    }
}