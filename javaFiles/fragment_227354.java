@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);  /**super keyword in java is a reference variable that
         is used to refer immediate parent class object. */
        setContentView(R.layout.activity_main);
        myPath = (TextView)findViewById(R.id.path); /* storing the current path*/

       if(getIntent() != null){
           root = getIntent().getStringExtra("DIR_PATH", root); //if is null then get root
        }
        getDir(root);
    }