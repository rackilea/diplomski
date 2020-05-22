@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_announcement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        int postion = getIntent().getIntExtra(EXTRA_POSITION, 0);

        //you can retrieve data from intent like
        String textViewDate = getIntent().getStringExtra("date");
        String textViewTitle = getIntent().getStringExtra("title");

        TextView announcementContent = (TextView) findViewById(R.id.textAnnouncementContext);
        TextView announcementDate = (TextView) findViewById(R.id.textAnnouncementDate);
        ImageView announcementImage = (ImageView) findViewById(R.id.AnnouncementImageView);
        TextView announcementOtherDetails = (TextView) findViewById(R.id.textAnnouncementOtherDetails);


    }