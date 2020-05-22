public class MainActivity extends Activity implements OnClickListener {

    private TextView mMain;

    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_screen);

        mMain = (TextView) findViewById(R.id.maintextView);
        mMain.setText("0");

        Button btnSeven = (Button) findViewById(R.id.btnseven);
        btnSeven.setOnClickListener(this);
    } 

    @Override 
    public void onClick(View view) {
        String mainText = mMain.getText().toString();
        try {
            // By parsing the text as a number, you make sure you handle the cases where the user added input like "0." too, so you don't have to handle each and every case with Strings and with if-else statements.
            double actualNumber = Double.parseDouble(mainText);
            if (actualNumber == 0) {
                mMain.setText("");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            // Something went wrong while parsing. Usually happens because the EditText contains other characters the digits or "."
        }

        switch(view.getId()) {
            case R.id.btnseven:
                mMain.append("7");
                break; 
            default : 
                break; 
        } 
    } 
}