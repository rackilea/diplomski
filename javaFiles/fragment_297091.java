public class So extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button) findViewById(R.id.button); 

        button.setOnClickListener(new View.OnClickListener() {
            // anonymous inner class
            public void onClick(View view) {
                EditText editText1 = (EditText) findViewById(R.id.edit_text);
                Editable editable = editText1.getText();
                responsePost(editable);
                editText1.setText("");
            }
        });
    }

    public void responsePost(Editable editable) {
        TableLayout chatbox = (TableLayout) findViewById(R.id.chatbox);
        TableRow tr1 = new TableRow(this);
        // add these lines here
        TextView col1 = new TextView(this);
        col1.setText("");
        tr1.addView(col1);
        TextView textview = new TextView(this);
        textview.setGravity(Gravity.RIGHT);
        textview.setText(editable);
        textview.setTextColor(Color.YELLOW);
        tr1.addView(textview);
        // and this line
        chatbox.setColumnStretchable(1, true);
        chatbox.addView(tr1, new TableLayout.LayoutParams(
                LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
    }
}