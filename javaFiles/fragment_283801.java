public static final String HungerValueTag = "HungerValue";
 // Add the same for the other three..

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ...

        String hunger = getIntent().getStringValue(HungerValueTag);
        String cuisine = getIntent().getStringValue(CuisineValueTag);
        // get the other two


        List<String> results = databaseAccess.getResult(hunger, cuisine, prep, course);

        ...
    }