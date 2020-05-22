@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    try {
            Button btnShowCamera = (Button) findViewById(R.id.btn_show_camera);
            btnShowCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Log.i(LOG_TAG, "Show camera button pressed.");
            askForPermission();
            }

        });
    } catch (Exception e) {
        e.printStackTrace();
    }
}

void askForPermission() {
    MainActivityPermissionsDispatcher.showCameraWithCheck(this);
}

@NeedsPermission(Manifest.permission.CAMERA)
void showCamera() {
    Toast.makeText(this, "Showing camera", Toast.LENGTH_LONG).show();
}