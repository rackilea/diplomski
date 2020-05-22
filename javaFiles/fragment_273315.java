public class PayActivity extends ActionBarActivity {
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        value = getIntent().getStringExtra("transaction_amount");
    }
    public void yourFunction() {
        // You can acces value here
    }

// your activity here....
}