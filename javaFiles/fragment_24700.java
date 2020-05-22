private static int RESULT_LOAD_IMAGE = 1;
private final String FILEPATH = "FilePath";

SharedPreferences prefs;


@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    prefs = this.getSharedPreferences("com.example.app", Context.MODE_PRIVATE);        

    Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);
    buttonLoadImage.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            Intent i = new Intent(
                    Intent.ACTION_PICK,
                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

            startActivityForResult(i, 1);
        }
    });
}


@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
        Uri selectedImage = data.getData();
        String[] filePathColumn = { MediaStore.Images.Media.DATA };

        Cursor cursor = getContentResolver().query(selectedImage,
                filePathColumn, null, null, null);
        cursor.moveToFirst();

        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        String picturePath = cursor.getString(columnIndex);
        cursor.close();

        prefs.edit().putString(FILEPATH, picturePath);

    }


}