public class MainActivity extends Activity {

        private static final int FILE_SELECT_CODE = 0;
        private static final String TAG = null;
        public TextView tv;
        public ImageView iv;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            tv=(TextView) findViewById(R.id.textView1);
            iv=(ImageView) findViewById(R.id.imageView1);
            Button b=(Button) findViewById(R.id.button1);


            b.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    showFileChooser();

                }
            });
        }


        private void showFileChooser() {

            Intent intent = new Intent(Intent.ACTION_GET_CONTENT); 
            intent.setType("*/*"); 
            intent.addCategory(Intent.CATEGORY_OPENABLE);

            try {
                startActivityForResult(
                        Intent.createChooser(intent, "Select a File to Upload"),
                        FILE_SELECT_CODE);
            } catch (android.content.ActivityNotFoundException ex) {
                // Potentially direct the user to the Market with a Dialog
                Toast.makeText(this, "Please install a File Manager.", 
                        Toast.LENGTH_SHORT).show();
            }
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            switch (requestCode) {
                case FILE_SELECT_CODE:
                if (resultCode == RESULT_OK) {
                    // Get the Uri of the selected file 
                    Uri uri = data.getData();
                    iv.setImageURI(uri);
                    Log.d(TAG, "File Uri: " + uri.toString());
                   }
                break;
            }
            super.onActivityResult(requestCode, resultCode, data);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
        }

    }