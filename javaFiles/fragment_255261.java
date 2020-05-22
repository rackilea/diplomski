// Your AndroidLauncher
public class AndroidLauncher extends AndroidApplication implements MyGame.MyGameCallback {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        // create an instance of MyGame, and set the callback
        MyGame myGame = new MyGame;
        // Since AndroidLauncher implements MyGame.MyGameCallback, we can just pass 'this' to the callback setter.
        myGame.setMyGameCallback(this);

        initialize(myGame, config);
    }

    @Override
    public void onStartActivityA() {
        Intent intent = new Intent(this, ActivityA.class);
        startActivity(intent);
    }

    @Override
    public void onStartActivityB(){
        Intent intent = new Intent(this, ActivityB.class);
        startActivity(intent);
    }

    @Override
    public void onStartSomeActivity(int someParameter, String someOtherParameter){
        Intent intent = new Intent(this, ActivityA.class);

        // do whatever you want with the supplied parameters.
        if (someParameter == 42) {
            intent.putExtra(MY_EXTRA, someOtherParameter);
        }
        startActivity(intent);
    }

}