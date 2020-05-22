//To save team score
SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
SharedPreferences.Editor e = settings.edit();

e.putString("teamScore1", firstTeam.getText().toString()); //1st Team
e.putString("teamScore2", secondTeam.getText().toString()); //2nd Team

e.commit();

//Retrieve team score
String team1 = settings.getString("teamScore1", "");
String team2 = settings.getString("teamScore2", "");