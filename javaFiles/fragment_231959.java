class MyApp extends Application {
    private static String someResource = null;
    public static String getSomeResource(Context context) {
       if(someResource == null) {
           SharedPrefrences prefs = (SharedPrefrences)
                  context.getSystemService(Context.SHARED_PREFRENCES);
           someResource = prefs.getString(SOME_RESOURCE, null);
       }
    return someResource;
 }