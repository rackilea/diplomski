public class Start extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

        /**
        set a bunch of variables to be used in all activities
        **/

        public static ...
        public static ... ...
        public static int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 0;



        public void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_wait); //this is a view with a progress bar
            checkPermission();

        }

        private void permissionsGranted() {

                 /**
            do some stuff at startup, like creating some directories if not already present
            **/

            launchIntent(this, Home.class); //launch the home screen after initializing all variables and creating directories
            finish();


        }



        private void checkPermission() {
            if (ContextCompat.checkSelfPermission(Start.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                // do this if permisisons have not yet been granted
                Log.d("permission", "NOT granted");
                ActivityCompat.requestPermissions(Start.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
            }else{
                // if the permissions have already been granted do the following
                Log.d("permission", "granted");
                permissionsGranted();
            }
        }

        // this is required when ActivityCompat.requestPermissions() is called
        @Override
        public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
            switch (requestCode) {
                case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE: {

                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                       // if permissions have been granted, do the following 
                        permissionsGranted();
                    } else {
                        // possibly prompt why permissions are required and try again
                    }
                    return;
                }

                // other 'case' lines to check for other
                // permissions this app might request.
            }
        }

    }