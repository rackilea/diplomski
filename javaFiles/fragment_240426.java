public void startGame(){
    initPlayers();
    linkIds();
    initBtns();
    initCells();
    initLinkedList();
    randomPlayerStart();
    hand = new Hand(0);

    switchTurn();
    presenter = new MainActivityPresenter(MainActivity.this, playerA, playerB );



}
public void randomPlayerStart() {
    presenter.randomPlayerStart();
}