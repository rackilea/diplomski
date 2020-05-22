public class ShowStations extends ActionBarActivity {

    DatabaseSourceStations databaseSourceStations;
    Station aStation = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_stations2);

        int stationID = getIntent().getIntExtra("station_id", 0);

        databaseSourceStations = new DatabaseSourceStations(this);
        try {
            databaseSourceStations.open();

            // retrieve the station details from the database here, 
            // I assume you have a method called 'getSingleStationDetails' 
            // that returns a single station with the specified ID

            aStation = databaseSourceStations.getSingleStationDetails(stationID);

        } catch (IOException e) {
            e.printStackTrace();
        }

        databaseSourceStations.close();

        //TextViews werden eingebunden
        TextView station_ckanal = (TextView) findViewById(R.id.tv_show_ckanal);
        TextView station_fdl = (TextView) findViewById(R.id.tv_show_fdl);
        TextView station_lastrecke = (TextView) findViewById(R.id.tv_show_laStrecke);
        TextView station_linie = (TextView) findViewById(R.id.tv_show_linie);
        TextView station_art = (TextView) findViewById(R.id.tv_art);

        if (aStation != null) {
            // set the details of the text views here
        }

    }

    ...