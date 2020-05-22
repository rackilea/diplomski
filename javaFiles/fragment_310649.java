@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mp = MediaPlayer.create(getApplicationContext(), resid[res]);
    // ...
}