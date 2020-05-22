public void addOneforTeamA(View v) {
    aTeamStack.push(1);
    displayForTeamA();
}

public void undoLastForA() {
    aTeamStack.pop();
    displayForTeamA();
}

public void displayForTeamA() {
    ((TextView) findViewById(R.id.team_a_score)).setText(aTeamStack);
}