public class AndroidLauncher extends AndroidApplication implements PlatformResolver {

    public void handleTasks(){
        //Do stuff with TaskSets
    }

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        someDataType SomeData;

        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        // config stuff
        initialize(new MyGame(this), config);
    }

}