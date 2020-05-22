public class MyGameEngine {

    public PlayerData getPlayerData() { ... }

    public void sellSomeStuff(int numberOfStuff) throws InvalidPlayerOperation {
        if (numberOfStuff > getPlayerData().getAmountOfStuff() {
            throw new InvalidPlayerOperation("Not enough stuff");
        }
        ....
    }
}

public class PlayerData {

    public int getAmountOfStuff() { ... }
}

public class InvalidPlayerOperation extends RuntimeException { ... }