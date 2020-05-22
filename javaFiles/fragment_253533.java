public class AddMoneyTransaction extends AppCompatActivity implements View.OnClickListener {

        Button addDepositButton;
        EditText depositInput, depositInputDate, depositInputNote;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_money_transaction);

            //setup the Button and EditText

            addDepositButton = (Button)findViewById(R.id.addDepositButton);
            depositInput = (EditText) findViewById(R.id.depositInput);
            depositInputDate = (EditText) findViewById(R.id.depositInputDate);
            depositInputNote = (EditText) findViewById(R.id.depositInputNote);

            //get the onClickListener
            addDepositButton.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            Intent depositIntent = new Intent(AddMoneyTransaction.this, AssetsOverview.class);
           Transaction deposit = new Transaction(100, 16, "random comment");
           deposit.setValue(Float.parseFloat(depositInput.getText().toString()));
           deposit.setTransaction_Date(
Integer.parseInt(depositInputDate.getText().toString()));
           deposit.setDescription(depositInputNote.getText().toString());
           depositIntent.putExtra("data",deposit);
           startActivity(depositIntent);
        }