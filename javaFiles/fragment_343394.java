private static final int REQUEST_PERMISSIONS = 10;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (Build.VERSION.SDK_INT >=23)
        {
            getPermission();
        }
        else
        {
            initView();

        }
}

private void initView()
{
    setContentView(R.layout.activity_main);
    ...
    ..
}

@TargetApi(Build.VERSION_CODES.M)
private void getPermission()
{
    if (ContextCompat.checkSelfPermission(StartActivity.this, Manifest.permission.CAMERA)
        + ContextCompat.checkSelfPermission(StartActivity.this, Manifest.permission.RECORD_AUDIO)
        != PackageManager.PERMISSION_GRANTED) {

        Log.i("Permission is require first time", "...OK...getPermission() method!..if");
        ActivityCompat.requestPermissions(StartActivity.this,
            new String[]{Manifest.permission.CAMERA,
                    Manifest.permission.RECORD_AUDIO},
                REQUEST_PERMISSIONS);

    }
    else
    {
        initView();

    }
}

@Override
    public void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_PERMISSIONS) {
            if ((grantResults.length > 0) && (grantResults[0]+grantResults[1])
                    == PackageManager.PERMISSION_GRANTED) {
                // Permission granted.
               initView();
            } else {

                Toast.makeText(StartActivity.this, "All Permission is Required, Toast.LENGTH_LONG).show();
                getPermission()
            }
        }
    }