public class MainActivity extends AppCompatActivity {
    CheckBox hasWhippedCream;
    boolean checked;
    int quantity = 0;
    int pricePerCup = 5;
    int toppingPrice = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hasWhippedCream = (CheckBox) findViewById(R.id.toppings_checkbox);
        hasWhippedCream.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                checked = isChecked;
            }
        });
        checked = hasWhippedCream.isChecked();
    }

   // rest is the same
}