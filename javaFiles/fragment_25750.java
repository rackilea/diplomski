@JsonIgnoreProperties(ignoreUnknown = true)
public class Player {
    private int hp;
    private int air;
    private boolean hasCalledHelp = false;
    private boolean wonGame = false;
    public String playerName = "Mads"; // Non-negotiable
    public int awesomePoints = 0;
    public int totalTimePlayed = 0;

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public int getAir() {
        return air;
    }
    public void setAir(int air) {
        this.air = air;
    }
    public boolean isHasCalledHelp() {
        return hasCalledHelp;
    }
    public void setHasCalledHelp(boolean hasCalledHelp) {
        this.hasCalledHelp = hasCalledHelp;
    }
    public boolean isWonGame() {
        return wonGame;
    }
    public void setWonGame(boolean wonGame) {
        this.wonGame = wonGame;
    }
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public int getAwesomePoints() {
        return awesomePoints;
    }
    public void setAwesomePoints(int awesomePoints) {
        this.awesomePoints = awesomePoints;
    }
    public int getTotalTimePlayed() {
        return totalTimePlayed;
    }
    public void setTotalTimePlayed(int totalTimePlayed) {
        this.totalTimePlayed = totalTimePlayed;
    }
}