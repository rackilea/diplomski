public class MyActivity extends Activity {
    // Your Message Format
    private static final String MSG_FORMAT = "Item Name: %s\n"
            + "Fat: %s\n"
            + "Protein: %s\n"
            + "Calories: %s";

    // A Map to hold info of all items
    // Key = button title
    // Value = Array containing item info
    private Map<String, String[]> info = new HashMap();

    // Assuming you have 3 buttons in your activity
    private Button btnMilk;
    private Button btnEggs;
    private Button btnChicken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);

        btnMilk = (Button) findViewById(R.id.btn_milk);
        btnEggs = (Button) findViewById(R.id.btn_eggs);
        btnChicken = (Button) findViewById(R.id.btn_chicken);

        // 0 = Fat, 1 = Protein, 2 = Calories
        String[] milkInfo = new String[]{"12", "20", "125"};
        String[] eggsInfo = new String[]{"10", "50", "205"};
        String[] chickenInfo = new String[]{"50", "5", "500"};

        // load your Map with the data
        info.put(btnMilk.getText(), milkInfo);
        info.put(btnEggs.getText(), eggsInfo);
        info.put(btnChicken.getText(), chickenInfo);

    }

    public void displayMessage(View v) {
        Button button = (Button) v;

        String title = button.getText();

        // Get item info from your Map
        String[] itemInfo = info.get(title);

        // Create message using the format and values from the array
        String message = String.format(MSG_FORMAT, title, itemInfo[0], itemInfo[1], itemInfo[2]);

        Toast.makeText(MyActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}