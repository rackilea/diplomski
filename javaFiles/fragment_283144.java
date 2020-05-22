private GameScene gameScene;
private TextView fpsCounter;

@Override
protected void onCreate(Bundle savedInstanceState) {
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    super.onCreate(savedInstanceState);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.game);

    fpsCounter = findViewById(R.id.fps_counter);
    gameScene = new GameScene(this);
    LinearLayout gameHolder = (LinearLayout)findViewById(R.id.game_view);
    gameHolder.addView(gameScene);
    gameScene.resume();
}

public void setFps(String fps) {
    fpsCounter.setText(fps);
}