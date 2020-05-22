class IceHockeyPlayerAdapter implements SportsPlayer {
    private IceHockeyPlayer player;
    public IceHockeyPlayerAdapter(IceHockeyPlayer p) { player = p; }

    public void play(int meters) {
        player.playPuck(meters);
    }
    public void move(double speed) {
        player.skateForward(speed);
    }
}