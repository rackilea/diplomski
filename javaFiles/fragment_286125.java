public class Main extends Activity {

    Button reverse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView displayed = (TextView)findViewById(R.id.displayName);
        EditText nametext = (EditText)findViewById(R.id.name);
        String namestring = nametext.getText().toString();

        reverse=(Button)findViewById(R.id.reverse);//assuming you have button with id reverse

            reverse.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub

                    String reverse = new StringBuffer(namestring).reverse().toString();
                    String dr = reverse;
                    displayed.setText(dr);

                }
            });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}