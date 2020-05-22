@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    sessionId = ActivityHelper.initializeSessionId(savedInstanceState, this);

    finish();
}
...