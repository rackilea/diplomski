Button button=null;
    boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    button=(Button)findViewById(R.id.button1);
    button.setOnClickListener(new OnClickListener() {

        @Override
        public void onClick(View v) {
            if(flag)
            {
                flag=false;
            }
            else
            {
                flag=true;
            }
            registerForContextMenu(v);
            openContextMenu(v);
        }
    });
    }