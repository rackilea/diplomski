public void onClickGoToTeamSummary(View view)
{
    Intent intentTeamNames = new Intent(MainActivity.this, ResultsActivity.class);

    intentTeamNames.putExtra("footballClubs", myTeams);
    intentTeamNames.putExtra("clubPoints", pointsAttained);
    intentTeamNames.putExtra("clubGoals", goalsScored);

    startActivity(intentTeamNames);
}