public class MainActivity
        extends AppCompatActivity
        implements StateChanger {
    private static final String TAG = "MainActivity";

    @BindView(R.id.fragment)
    ViewGroup root;

    FragmentStateChanger fragmentStateChanger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragmentStateChanger = new FragmentStateChanger(getSupportFragmentManager(), R.id.fragment);

        Navigator.configure()
                .setStateChanger(this)
                .install(this, root, History.single(FragmentOneKey.create()));
    }

    @Override
    public void onBackPressed() {
        if(!Navigator.onBackPressed(this)) {
            super.onBackPressed();
        }
    }


    public void showSecondFragment(String data) {
         Navigator.getBackstack(this).goTo(FragmentTwoKey.create(data));
    }

    // this handles navigation from any nav state to any other nav state
    @Override
    public void handleStateChange(@NonNull StateChange stateChange, @NonNull Callback completionCallback) {
        if(stateChange.isTopNewKeyEqualToPrevious()) {
            completionCallback.stateChangeComplete();
            return;
        }
        fragmentStateChanger.handleStateChange(stateChange);
        completionCallback.stateChangeComplete();
    }
}