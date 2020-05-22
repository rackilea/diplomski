public class LoginActivity extends FragmentActivity implements LoaderManager.LoaderCallbacks<LoginResponse> {

    private String username,password;       
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Loader loader = getSupportLoaderManager().getLoader(0);
        if (loader != null) {
            getSupportLoaderManager().initLoader(0, null, this);
        }
    }

    public void loginSubmit(View button) {
            Bundle data = new Bundle();
            data.putString("username", getUsername());
            data.putString("password", getPassword());  
            getSupportLoaderManager().restartLoader(0, data, this);
    }   


    @Override
    public Loader<LoginResponse> onCreateLoader(int i, Bundle bundle) {
    //might want to start a progress bar
        ApiClient client = new ApiClient();
        LoginApi loginApi = new LoginApi(bundle.getString("username"), bundle.getString("password"));
        return new LoginAsyncTaskLoader(this, apiClient, loginApi);
    }


    @Override
    public void onLoadFinished(Loader<LoginResponse> loginLoader,
                               LoginResponse loginResponse)
    {
        //handle result, maybe send to a new activity if response doesn't have an error

    }

    @Override
    public void onLoaderReset(Loader<LoginResponse> responseAndJsonHolderLoader)
    {
        //not sure if anything needs to be done here to do

    }
}