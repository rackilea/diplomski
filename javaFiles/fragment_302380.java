public static class PlatformAndPlayer {
    private final int playerId, platformId;

    public PlatformAndPlayer(int playerId, int platformId) {
        this.playerId = playerId;
        this.platformId = platformId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + platformId;
        result = prime * result + playerId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PlatformAndPlayer other = (PlatformAndPlayer) obj;
        if (platformId != other.platformId)
            return false;
        if (playerId != other.playerId)
            return false;
        return true;
    }
}