public class LineGraph {
    public Intent getIntent(Context context) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        // Our first data
        int[] x = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // x values!
        ...