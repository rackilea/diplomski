public class A extends AppCompatActivity {
    @Inject
    B b;
    @Inject
    C c;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies()
        setContentView(R.layout.activity_main);
        // working with b and c
    }

    private void injectDependencies() {
        App.get(this).applicationComponent().inject(this);
    }
}