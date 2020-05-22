public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicked(View view){
        Toast.makeText(this, "Hey! Im clicked!",Toast.LENGTH_SHORT).show();
    }

}