public class MainActivity extends AppCompatActivity
{
    public interface MyInterfcae
    {
        void test0(Context context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Test t = new Test();
        t.test0(this);
    }
}