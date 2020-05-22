public class MainActivityPresenter {
MainActivityView view;
Player playerA, playerB;


public MainActivityPresenter(MainActivityView view, Player playerA, Player playerB) {


    this.view = view;
    this.playerA = playerA;
    this.playerB = playerB;

}

public void randomPlayerStart() {
    Random random = new Random();
    boolean player = random.nextBoolean();

    if (player) {
        playerA.setTurn(true);
    } else {
        playerB.setTurn(true);


    }
}

public void initPlayers() {
    playerA = new Player("Player A", false);
    playerB = new Player("Player B", false);
    }
}