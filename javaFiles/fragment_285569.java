//set up class fields/members
private final static String STATE_G_VALS = "STATE_G_VALS";
SomeIntegers g_values = null;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test_bundle);
    System.out.println("onCreate (" + (savedInstanceState == null ? "null)" : "set)"));
    if (savedInstanceState != null) {
        // get g_values back here
        g_values = savedInstanceState.getParcelable(STATE_G_VALS);
    }

    if (g_values == null) {
        // ok its null, lets make one
        g_values = new SomeIntegers();
    }
    // log some stuff
    String result = g_values.report();
    System.out.println("Result: " + result);
}
@Override
protected void onSaveInstanceState(Bundle outState) {
    //set g_values to the Bundle/saved state (even if it is null)
    outState.putParcelable(STATE_G_VALS, g_values);
    super.onSaveInstanceState(outState);
}