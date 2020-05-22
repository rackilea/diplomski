protected void onCreate(Bundle savedInstanceState) 
{
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_results);

    Intent intentClubNames = getIntent();
    String[] club_names = intentClubNames.getStringArrayExtra("footballClubs");
    int[] team_points = intentClubNames.getIntArrayExtra("clubPoints");
    int[] club_goals = intentClubNames.getIntArrayExtra("clubGoals");
}