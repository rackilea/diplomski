public void openHiScore(){
            Intent intent = new Intent(this,HiScore.class);
            Bundle b = new Bundle();
            b.putString("name", editText.getText().toString());
            intent.putExtras(b)
            startActivity(intent);

        }

In the HiScore class extract the data from the Bundle.

public class HiScore extends AppCompatActivity {

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hiscore);

        Intent in = getIntent();
        // get the Bundle that stores the data of this Activity
        Bundle b = in.getExtras();

        // getting data from bundle
        String name = b.getString("name");
    }
}