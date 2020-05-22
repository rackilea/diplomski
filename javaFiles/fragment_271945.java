public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //changeTest(this);

       AnotherActivity a = new AnotherActivity();
        a.updateTest(this);


    }

    public void changeTest(Activity activity) {
        TextView test = (TextView)activity.findViewById(R.id.textViewTest);
        test.setText("test");
    }
}