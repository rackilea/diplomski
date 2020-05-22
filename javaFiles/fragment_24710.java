public class MyApplication extends Application {

@Override
public void onCreate() {
    super.onCreate();
        // Initialize the Universal Image Loader here

    DisplayImageOptions defaultOptions = new 
    DisplayImageOptions.Builder()
            .cacheOnDisk(true).cacheInMemory(true).build();

    ImageLoaderConfiguration config = new 
    ImageLoaderConfiguration.Builder(getApplicationContext())
            .defaultDisplayImageOptions(defaultOptions).build();

    ImageLoader.getInstance().init(config);


}