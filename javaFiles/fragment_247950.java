public class MainActivity extends BaseActivity {


    @Inject
    RestApiHelper restApiHelper;
    Disposable disposable;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActivityComponent component = getActivityComponent();
        component.inject(this);

        disposable = restApiHelper.getquestionlist(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Object>() {
                    @Override
                    public void accept(Object o) throws Exception {
                        Log.d(TAG, "accept: "+ o.toString());    
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                    }
                });
    }

    @Override
    protected void onDestroy() {
        disposable.dispose(); // best practice
        super.onDestroy();
    }
}