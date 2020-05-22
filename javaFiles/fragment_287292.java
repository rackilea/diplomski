public ArrayList<String> winners() {
    ArrayList<String> result = new ArrayList<String>();

    int winningScore = winningScore();  

    for (int i = 0; i < players.size(); i++)
        if (players.get(i).totalScore() == winningScore)
            result.add(players.get(i).getName())

    return result;
}