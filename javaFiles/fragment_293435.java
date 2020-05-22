public enum Army {   
    SOLDIER(4),
    DEMOMAN(2),
    SCOUT(4),
    MEDIC(2);

    private final int maxPlayers;

    private Army(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }
}