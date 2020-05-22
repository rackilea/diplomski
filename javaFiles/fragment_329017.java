private static final Gson gson = new GsonBuilder()
        .registerTypeAdapter(Content.class, getContentJsonDeserializer())
        .create();

private static final Type userContent = new TypeToken<Content<User>>() {
}.getType();

public static void main(final String... args)
        throws IOException {
    for ( final String name : ImmutableList.of("success.json", "error.json", "success-reversed.json", "error-reversed.json") ) {
        try ( final JsonReader jsonReader = getPackageResourceJsonReader(Q44400163.class, name) ) {
            final Content<User> content = gson.fromJson(jsonReader, userContent);
            if ( content.isSuccess() ) {
                System.out.println("SUCCESS: " + content.getData().displayName);
            } else {
                System.out.println("ERROR:   " + content.getError().errorMessage);
            }
        }
    }
}