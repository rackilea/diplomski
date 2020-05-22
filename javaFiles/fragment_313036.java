public class AndroidLauncher extends AndroidApplication implements CustomHandler {

    @Override
    public void setOrientationPortrait(){
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void setOrientationLandscape(){
    this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        androidPref = getSharedPreferences("MyPref", Context.MODE_PRIVATE);

        View gameView = initializeForView(new GameClass(this), config);
        setContentView(gameView);    
}