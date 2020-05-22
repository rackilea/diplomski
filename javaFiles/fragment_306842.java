public class ShowCarPrice extends AppCompatActivity {

    // OK, Create the objects, variables here if needed
    Intent intent;
    String brand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.your_activity_layout);

        // You should assign the intent here (in onCreate method)
        intent = getIntent();

        // Then, the string variable
        brand = intent.getStringExtra("brand");

        // You can also check whether or not received a valid value
        if (brand != null && !brand.isEmpty())
        // do something with brand value
        else
        // brand value is null or empty
    }
}