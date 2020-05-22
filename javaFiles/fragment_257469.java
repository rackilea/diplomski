for (int i = 0; i < teams; i++) {
    tArr[i] = new Team();
    tArr[i].getInfo1();
    players = tArr[i].num_players;    
        //  this way you will loop over the num_players of the new team you created
        //  MAYBE this is the problem
    player[] pArr = new player[players];
    for (int j = 0; j < players; j++) {
        pArr[j] = new player();
        pArr[j].getInfo();
    }
}