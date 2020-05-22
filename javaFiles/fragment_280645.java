private static final Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(getNotNullTypeAdapterFactory())
        .create();

public static void main(final String... args)
        throws IOException {
    for ( final String resourceName : ImmutableList.of("file-with-roll.json", "file-without-roll.json") ) {
        System.out.println("Deserializing " + resourceName);
        try ( final JsonReader jsonReader = getPackageResourceJsonReader(Q44362030.class, resourceName) ) {
            try {
                final Person person = gson.fromJson(jsonReader, Person.class);
                System.out.println(person.name + " " + person.roll);
            } catch ( final Exception ex ) {
                System.out.println("FAILED! " + ex.getMessage());
            }
        }
    }
}