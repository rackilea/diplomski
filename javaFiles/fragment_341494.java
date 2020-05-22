int length = scoreboard.length; 
for (int i = 0; i < length-1; i++){ 
    for (int j = 0; j < length-i-1; j++){ 
        if (scoreboard[j].getScore() > scoreboard[j+1].getScore()){ 
            Player temp = scoreboard[j]; 
            scoreboard[j] = scoreboard[j+1]; 
            scoreboard[j+1] = temp; 
        } 
    }
}