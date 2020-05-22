public void setPlayers(Profile player) {
    if (this.players == null)
        this.players = new Profile[4];
    if (plc < 4) {
        this.players[plc] = new Profile(); // Exception
        this.players[plc] = player;
        plc++;
    }
}