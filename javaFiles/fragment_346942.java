public class Stroop extends ActionBarActivity {

    HashMap<String, Integer> colors = new HashMap<>();

    Object stringOnScreen[];
    Object colorsOnScreen[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stroop);

        setUpGame()

        stringOnScreen = colors.keySet().toArray();
        colorOnScreen = colors.values().toArray();

        Log.d("test", "test: " + stringOnScreen[2].toString());

    }

    ...
}