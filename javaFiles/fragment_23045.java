public class Battleground {
    // ...

    public void startRound() {
        // let the particular Hero subclass control what happens
        player.onRoundStart();

        // ...
    }
}