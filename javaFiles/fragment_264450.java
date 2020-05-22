private void setHighScore()
{
    //set high score
    int exScore = getScore();

    if(exScore>0)
    {
        //we have a valid score
        SharedPreferences.Editor scoreEdit = gamePrefs.edit();
        DateFormat dateForm = new SimpleDateFormat("dd MMMM yyyy");
        String dateOutput = dateForm.format(new Date());
        String scores = gamePrefs.getString("highScores", "");

        if(scores.length()>0)
        {
            //we have existing scores
        }
        else
        {
            //no existing scores
            scoreEdit.putString("highScores", ""+dateOutput+" - "+exScore);
            scoreEdit.commit();

            List<Score> scoreStrings = new ArrayList<Score>();
    String[] exScores = scores.split("\\|"); // error: scores cannot be resolved
    for(String eSc : exScores)
    {
        String[] parts = eSc.split(" - ");
        scoreStrings.add(new Score(parts[0], Integer.parseInt(parts[1])));
    }

    Score newScore = new Score(dateOutput, exScore); // error: dateOutput cannot be resolved to a variable
    scoreStrings.add(newScore);
    Collections.sort(scoreStrings);

    StringBuilder scoreBuild = new StringBuilder("");
    for(int s=0; s<scoreStrings.size(); s++)
    {
        if(s>=10) break;//only want ten
        if(s>0) scoreBuild.append("|");//pipe separate the score strings
        scoreBuild.append(scoreStrings.get(s).getScoreText());
    }
    //write to prefs

    scoreEdit.putString("highScores", scoreBuild.toString()); //error: scoreEdit cannot be resolved
    scoreEdit.commit(); //error: scoreEdit cannot be resolved
        }
    }
}