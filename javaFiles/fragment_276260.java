public class PlayerType {
    public abstract PlayerTypes getType();
}

public class GoodPlayer extends PlayerType {
    @Override
    public PlayerTypes getType() {
        return PlayerTypes.GOOD;
    }
}