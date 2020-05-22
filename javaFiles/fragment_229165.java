//this is somewhat messy, but it gets the point across
    Player p = users.get(0);
    int playerIndex = users.size();
    while(p.getScoreTotal() < 100) {
        if(playerIndex == users.size()) {
            playerIndex = 0;
        }
        p = users.get(playerIndex);
        playerIndex++;
        System.out.println(p.getNick() + "'s turn!"); 
        System.out.println("Your score is: " + p.getScoreTotal() + "!");
        takeTurn(p);              
    } 
    System.out.println(p.getNick() + "wins! Congratulations"); 
    return;