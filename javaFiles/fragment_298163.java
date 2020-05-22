public class PlayerStatisticsId implements Serializable {
    //..
    private long player;

    private int matchday;

    public long getPlayer() {
        return player;
    }

    public int getMatchday() {
        return matchday;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof PlayerStatisticsId) {
            final PlayerStatisticsId o = (PlayerStatisticsId) obj;
            return o.matchday == matchday && o.player == player;
        } else {
            return false;
        }
    }
}