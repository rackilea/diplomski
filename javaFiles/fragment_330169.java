public class MainActivity extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // Adding Action to the Button
    Button BtnSubmit = (Button)findViewById(R.id.BtnSubmit);
    EditText firstEditText = (EditText) findViewById(R.id.firstEditText);
    EditText secondEditText = (EditText) findViewById(R.id.secondEditText);
    TextView resultTextView = (TextView) findViewById(R.id.resultTextView);

    BtnSubmit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String TbName = firstEditText.getText();

            int TbAge = Integer.parseInt(secondEditText.getText().toString());
            String TxtOuput;

            if (TbAge>0 && TbAge<=18)
            {
                TxtOuput = TbName + ("You Are Still A Child");
            }
            else if(TbAge>18 && TbAge<=64)
            {
                TxtOuput = TbName + ("You Are Grown");
            }
            else if(TbAge>64)
            {
                TxtOuput = TbName + ("You Are About To Die") + ("R.I.P");
            }
            resultTextView.setText(TxtOuput);

        }
    });
}

}