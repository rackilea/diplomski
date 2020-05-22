private CatchGame mCatchGame;
private TextView mTextView;
private Button mButton;
private Spinner mSpinner;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mCatchGame = (CatchGame) findViewById(R.id.catch_game);
    mTextView = (TextView) findViewById(R.id.tv_score);
    mButton = (Button) findViewById(R.id.btn_pause);
    mSpinner = (Spinner) findViewById(R.id.spinner);

    // do something here you want
}