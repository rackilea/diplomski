@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
     if (!checkAndAskForContactPermission()) return;
... your stuff here
}