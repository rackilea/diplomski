public void addTeamA3(View view){
        teamAScore += 3;
        updateA(teamAScore);
    }

    public void addTeamA2(View view){
        teamAScore += 2;
        updateA(teamAScore);
    }

    public void addTeamAFreeThrow(View view){
        teamAScore++;
        updateA(teamAScore);
    }

    public void addTeamB3(View view){
        teamBScore += 3;
        updateB(teamBScore);// teamBScore
    }

    public void addTeamB2(View view){
        teamBScore += 2;
        updateB(teamBScore);
    }

    public void addTeamBFreeThrow(View view){
        teamBScore++;
        updateB(teamBScore);
    }

    public void reset(View view){
        teamAScore = 0;
        teamBScore = 0;
        updateA(teamAScore);
        updateB(teamBScore);
    }