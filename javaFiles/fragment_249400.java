GameView gameView ;
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        gameView = new GameView(this); 
        setContentView(gameView);
    }

 @Override
protected void onPause() {
    // TODO Auto-generated method stub
    super.onPause();
    gameView.StopView();

}