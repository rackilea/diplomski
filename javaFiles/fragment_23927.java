private static final Gson gson = new GsonBuilder()
        .setFieldNamingStrategy(getDynamicSerializedNameStrategy(System::getProperty))
        .create();

public static void main(final String... args)
        throws IOException {
    try ( final Reader reader = getPackageResourceReader(Q43517297.class, "arbitrary.json") ) {
        final Model model = gson.fromJson(reader, Model.class);
        System.out.println(model.field);
    }
}