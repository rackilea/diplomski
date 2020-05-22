public class MainActivity extends Activity {
     int i;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        final LinearLayout main = (LinearLayout) findViewById(R.id.ll);
        TextView getData = new TextView(this);
        getData.setText("Enter the number of LineData : ");
        getData.setId(5);
        getData.setLayoutParams(params);
        main.addView(getData);
        final EditText edText = new EditText(this);
        edText.setId(3);
        edText.setLayoutParams(params);
        edText.setWidth(100);
        edText.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        edText.setInputType(InputType.TYPE_CLASS_NUMBER);
        edText.setKeyListener(DigitsKeyListener.getInstance());
        edText.setMaxLines(1);
        main.addView(edText);
        Button bt = new Button(this);
        bt.setText("Click to enter Linedata");
        bt.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
                LayoutParams.WRAP_CONTENT));
        main.addView(bt);
        final TextView text = new TextView(this);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String ed = edText.getText().toString();

                try {
                    i = Integer.parseInt(ed);
                    // setting value here
                    text.setText(String.valueOf(i));
                    // or you can do like this
                    // text.setText(String.valueOf(i));

                } catch (NumberFormatException ex) {
                    text.setText("Value at TextView is not a valid integer");
                }
            }
        });
        main.addView(text);
        final TextView text2 = new TextView(this);
        Button two = new Button(this);
        two.setText("Second");
        main.addView(two);
        main.addView(text2);
        two.setOnClickListener(new OnClickListener()
        {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                text2.setText(String.valueOf(i));

            }

        });

    }

}