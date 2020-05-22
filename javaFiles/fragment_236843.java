if(players[i].getResult() < players[i+1].getResult()) {
        temp = players[i];
        players[i]=players[i+1];
        players[i+1] = temp;

        sorted = false;}
    }