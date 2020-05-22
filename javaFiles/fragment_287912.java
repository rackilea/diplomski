public class MyAsyncTaskLoader extends AsyncTaskLoader<String> {

    private final WeakReference<Activity> mActivity;

    public MyAsyncTaskLoader(Activity activity) {
        super(activity);
        mActivity = new WeakReference<>(activity);
    }

    public doYourThing() {
        Activity activity = mActivity.get();

        // if activity is destroyed and garbage collected,
        // it will be null
        if (activity != null) {
            activity.getYourView().setWhatever();
        }
    }
}