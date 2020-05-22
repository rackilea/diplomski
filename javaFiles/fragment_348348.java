@Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            //Define and initialize your kovil constructor with appropriate arguments.
            kovil insertData = new kovil(your_id, temple_name, temple_type, latitude,  longitude, image_name, year_build, address, 
                city, email, website, telephone1, telephone2,  Description);
            Dbhandler dbhand = new Dbhandler(this); 
            dbhand .Add_Temple(insertData );
         }