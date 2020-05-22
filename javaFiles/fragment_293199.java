boolean mGameType;
...

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mGameType = getIntent().getExtras().getBoolean("gameType");
    ...
}