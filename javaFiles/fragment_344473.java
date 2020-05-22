public class MyActivity extends Activity {
    EditText editText = (EditText) findViewById(R.Id.restaurantName); 

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    // At button push, this method is called, I checked that, but I would like to receive an Object of class mentioned below. 
    public void sendMessage(View view){
        Log.d(view.toString(),editText.getText().toString());
    }
}