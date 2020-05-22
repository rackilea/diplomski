public class MainActivity extends AppCompatActivity  {

    public static final int UPLOAD_ACTIVITY_CODE = 100;
    private BottomNavigationView navigation;
    private ImageView uploadImage;
    private Home home;
    private Trending trending;
    private Upload upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = findViewById(R.id.navigation);
        uploadImage = findViewById(R.id.uploadimg);
        home = new Home();
        trending = new Trending();
        upload = new Upload();

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.getMenu().findItem(R.id.home).setChecked(true);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, home)
                .add(R.id.frame, category)
                .add(R.id.frame, search)
                .commit();
        setTabStateFragment(TabState.HOME);

        uploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UploadActivity.class);
                startActivityForResult(intent, UPLOAD_ACTIVITY_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == UPLOAD_ACTIVITY_CODE && resultCode == UPLOAD_ACTIVITY_CODE && data != null) {
            String desc = data.getStringExtra("Desc");
            String title = data.getStringExtra("Title");
            String photo = data.getStringExtra("PhotoUri");
            String duration = data.getStringExtra("duration");
            String video = data.getStringExtra("videoUri");
            Bundle bundle = new Bundle();
            bundle.putString("desc", desc);
            bundle.putString("title", title);
            bundle.putString("photo", photo);
            bundle.putString("duration", duration);
            bundle.putString("videoUri", video);
            upload.setData(bundle);
            setTabStateFragment(TabState.UPLOAD);
        }
    }

    private void setTabStateFragment(TabState state) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (state) {
            case HOME: {
                transaction.show(home);
                transaction.hide(trending);
                transaction.hide(upload);
            }
            case TRENDING: {
                transaction.hide(home);
                transaction.show(trending);
                transaction.hide(upload);
            }
            case UPLOAD: {
                transaction.hide(home);
                transaction.hide(trending);
                transaction.show(upload);
            }
        }
        transaction.commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.home: {
                    setTabStateFragment(TabState.HOME);
                    return true;
                }
                case R.id.trending: {
                    setTabStateFragment(TabState.TRENDING);
                    return true;
                }
                case R.id.upload: {
                    setTabStateFragment(TabState.UPLOAD);
                    return true;
                }
            }
            return false;
        }
    };

    enum TabState {
        HOME,
        TRENDING,
        UPLOAD,
    }

}