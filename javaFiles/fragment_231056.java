int startRB;
int endRB = 19;

for (startRB = 0; endRB <= 19; startRB++) {
    for (int i = 0; i < premierLeagueClubs.length; i++) {
        rb[startRB] = new JRadioButton(premierLeagueClubs[i]);
        chooseClubPanel.add(rb[i]);
    }
}