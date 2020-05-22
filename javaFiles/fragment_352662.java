public class LeagueProfileEditActivity extends AppCompatActivity {

    League league;
    //public List<League> leaguesList = new ArrayList<>(); //<<<<<<<<<< DELETED
    //private LeagueAdapter mAdapter; //<<<<<<<<<< DELETED

    public DatabaseHelper db;

    private static final String PREFS_NAME = "prefs";
    private static final String PREF_BLUE_THEME = "blue_theme";
    private static final String PREF_GREEN_THEME = "green_theme";
    private static final String PREF_ORANGE_THEME = "purple_theme";
    private static final String PREF_RED_THEME = "red_theme";
    private static final String PREF_YELLOW_THEME = "yellow_theme";

    public String ln, bs, bsp, lw, ll;
    public int leagueId;

    @Override
    protected void onResume() {
        super.onResume();
        db = new DatabaseHelper(this);
        //mAdapter.notifyDatasetChanged(db.getAllLeagues()); //<<<<<<<<<< Not needed
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Use Chosen Theme
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean useBlueTheme = preferences.getBoolean(PREF_BLUE_THEME, false);
        if (useBlueTheme) {
            setTheme(R.style.AppTheme_Blue_NoActionBar);
        }
        boolean useGreenTheme = preferences.getBoolean(PREF_GREEN_THEME, false);
        if (useGreenTheme) {
            setTheme(R.style.AppTheme_Green_NoActionBar);
        }
        boolean useOrangeTheme = preferences.getBoolean(PREF_ORANGE_THEME, false);
        if (useOrangeTheme) {
            setTheme(R.style.AppTheme_Orange_NoActionBar);
        }
        boolean useRedTheme = preferences.getBoolean(PREF_RED_THEME, false);
        if (useRedTheme) {
            setTheme(R.style.AppTheme_Red_NoActionBar);
        }
        boolean useYellowTheme = preferences.getBoolean(PREF_YELLOW_THEME, false);
        if (useYellowTheme) {
            setTheme(R.style.AppTheme_Yellow_NoActionBar);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_profile_edit);

        //mAdapter = new LeagueAdapter(this, leaguesList); //<<<<<<<<<< not needed

        String savedLeagueId = String.valueOf(getIntent().getIntExtra("leagueId",2));
        leagueId = Integer.valueOf(savedLeagueId);

        getLeagueProfile(leagueId); //<<<<<<<<<< sets the values for league

        final Button save_button = (Button) findViewById(R.id.bSave);
        save_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                final EditText leagueName = findViewById(R.id.etLeagueName);
                final EditText basisScore = findViewById(R.id.etBasisScoreValue);
                final EditText basisScorePercentage = findViewById(R.id.etBasisScorePercentageValue);
                final EditText leagueWins = findViewById(R.id.etLeaguePointsWon);
                final EditText leagueLosses = findViewById(R.id.etLeaguePointsLost);

                int leagueId = league.getId();

                updateLeague(league, leagueName.getText().toString(), basisScore.getText().toString(), basisScorePercentage.getText().toString(), leagueWins.getText().toString(), leagueLosses.getText().toString(), leagueId);

                Intent intent = new Intent(getApplicationContext(), LeagueProfileViewActivity.class);
                intent.putExtra("leagueId", leagueId);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);

            }

        });

        final Button cancel_button = (Button) findViewById(R.id.bCancel);
        cancel_button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int leagueId = league.getId();
                Intent intent = new Intent(getApplicationContext(), LeagueProfileViewActivity.class);
                intent.putExtra("leagueId", leagueId);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);
            }

        });

    }

    public void getLeagueProfile(int position) {


        SQLiteOpenHelper database = new DatabaseHelper(this);
        SQLiteDatabase db = database.getReadableDatabase();

        Cursor viewLeagueProfile = db.query(League.TABLE_NAME, new String[]{League.COLUMN_ID, League.COLUMN_NAME, League.COLUMN_BASE_SCORE, League.COLUMN_BASE_SCORE_PERCENTAGE, League.COLUMN_WINS, League.COLUMN_LOSSES, League.COLUMN_TIMESTAMP}, League.COLUMN_ID + "=?", new String[]{String.valueOf(position)}, null, null, null, null);

        if (viewLeagueProfile.moveToFirst()) {

            //Prepare League Object
            league = new League(viewLeagueProfile.getInt(viewLeagueProfile.getColumnIndex(League.COLUMN_ID)), ln = viewLeagueProfile.getString(viewLeagueProfile.getColumnIndex(League.COLUMN_NAME)), bs = viewLeagueProfile.getString(viewLeagueProfile.getColumnIndex(League.COLUMN_BASE_SCORE)), bsp = viewLeagueProfile.getString(viewLeagueProfile.getColumnIndex(League.COLUMN_BASE_SCORE_PERCENTAGE)), lw = viewLeagueProfile.getString(viewLeagueProfile.getColumnIndex(League.COLUMN_WINS)), ll = viewLeagueProfile.getString(viewLeagueProfile.getColumnIndex(League.COLUMN_LOSSES)), viewLeagueProfile.getString(viewLeagueProfile.getColumnIndex(League.COLUMN_TIMESTAMP)));

            Log.e("values : ", ln + ", " + bs + ", " + bsp + ", " + lw + ", " + ll);

            final EditText leagueName = findViewById(R.id.etLeagueName);
            final EditText basisScore = findViewById(R.id.etBasisScoreValue);
            final EditText basisScorePercentage = findViewById(R.id.etBasisScorePercentageValue);
            final EditText leagueWins = findViewById(R.id.etLeaguePointsWon);
            final EditText leagueLosses = findViewById(R.id.etLeaguePointsLost);

            leagueName.setText(ln);
            basisScore.setText(bs);
            basisScorePercentage.setText(bsp);
            leagueWins.setText(lw);
            leagueLosses.setText(ll);

            Log.v("Cursor Object", DatabaseUtils.dumpCursorToString(viewLeagueProfile));

            //Close Database Connection
            viewLeagueProfile.close();
        }
    }

        private void updateLeague(final League league, String ln, String bs, String bsp, String lw, String ll, final int position) {

        //League n = leaguesList.get(position); //<<<<<<<<<<<<<<<<<<< ERROR

        //Updating League Object
        //n.setName(ln); //<<<<<<<<<< replaced by
        league.setName(ln)
        //n.setBaseScore(bs); //<<<<<<<<<< replaced by
        league.setBaseScore(bs);
        //n.setBaseScorePercentage(bsp); //<<<<<<<<<< replaced by
        league.setBaseScorePercentage(bsp);
        //n.setWins(lw); //<<<<<<<<<< replaced by
        league.setWinds(lw);
        //n.setLosses(ll); //<<<<<<<<<< replaced by
        league.setLosses(ll);

        //Updating The League In The Database
        db.updateLeague(league);

        //Refreshing The List
        //leaguesList.set(position, n); //<<<<<<<<<< DELETED NOT USED????
        //mAdapter.notifyItemChanged(position); //<<<<<<<<<< DELETED NOT USED????
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.league_profile_edit_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cancel) {
            /*Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            overridePendingTransition(0, 0);*/
            return true;
        }


        return super.onOptionsItemSelected(item);
    }
}