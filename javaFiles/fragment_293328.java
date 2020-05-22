public class Create extends AppCompatActivity {

    public static final String TAG = Create.class.getSimpleName();
    public static final int RC_CAMERA_PERMISSION = 1000;

    @Override public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // this layout has your CameraButton, right?
        setContentView(R.layout.layout_create);
    }

    public void openCamera (View v) {

        if(v.getId() == R.id.CAMERA) {

            openCamera();
        }
    }

    private void openCamera () {

        // check for camera permission
        int permissionCheck = ContextCompat.checkSelfPermission(Create.this, Manifest.permission.Camera);

        // do we have camera permission?
        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {

            // we have camera permission, open System camera
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intent, 0);
        }
        else {

            // we don't have it, request camera permission from system
            ActivityCompat.requestPermissions(thisActivity,
                new String[]{Manifest.permission.CAMERA},
                RC_CAMERA_PERMISSION);
        }

    }

    // result will come in this method, check if the permission was accepted?
    @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults){

        // check request code for permissions
        if(requestCode == RC_CAMERA_PERMISSION) {

            if(grantResults.length > 0 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                // camera permission was granted
                openCamera();

            } else {

                Log.d(TAG, "permissions not accepted");
            }

        }
    }
}