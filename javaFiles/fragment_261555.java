public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton speak = (ImageButton) findViewById(R.id.imageButton_Speak);

        speak.setOnClickListener(new OnClickListener(){

                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "teste", Toast.LENGTH_SHORT).show();
                    }
                });     

    }

}