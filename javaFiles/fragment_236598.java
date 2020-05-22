public class MainActivity extends SampleActivityBase {

// Whether the Log Fragment is currently shown
private boolean mLogShown;
public static final String TAG = "MainActivity";

EditText cardnumber;
TextView foodorders;
Button btnorder;
private static final int REQUEST_CODE = 10;


@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    cardnumber = (EditText) findViewById(R.id.card_account_field);
    cardnumber.setText(AccountStorage.GetAccount(getBaseContext()));
    cardnumber.addTextChangedListener(new AccountUpdater());
    foodorders = (TextView) findViewById(R.id.foodordershow);
    btnorder = (Button) findViewById(R.id.buttonorder);


    btnorder.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            String strcardnumber = cardnumber.getText().toString();
            Intent intent = new Intent(MainActivity.this, activityresult1.class);
            intent.putExtra("Card Number:", strcardnumber);
            //if you need to let activityresult1 back to MainActivity with data, you can use startActivityForResult, if not just use startActivity(intent).
            startActivityForResult(intent, REQUEST_CODE);
        }
    });

}

private class AccountUpdater implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // Not implemented.
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // Not implemented.
    }

    @Override
    public void afterTextChanged(Editable s) {
        String account = s.toString();
        AccountStorage.SetAccount(getBaseContext(), account);
    }