public class MainActivity extends AppCompatActivity {
    FrameLayout frameLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout=findViewById(R.id.fragment);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new MyFragment(),"").commit();

    }
}