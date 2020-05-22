@Override
public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);

    String[] paths = new String[] { DATA_PATH, DATA_PATH + "tessdata/" };

    for (String path : paths) {
        File dir = new File(path);
        if (!dir.exists()) {
            if (!dir.mkdirs()) {
                Log.v(TAG, "ERROR: Creation of directory " + path + " on sdcard failed");
                return;
            } else {
                Log.v(TAG, "Created directory " + path + " on sdcard");
            }
        }

    }

    // lang.traineddata file with the app (in assets folder)
    // You can get them at:
    // http://code.google.com/p/tesseract-ocr/downloads/list
    // This area needs work and optimization
    if (!(new File(DATA_PATH + "tessdata/" + lang + ".traineddata")).exists()) {
        try {

            AssetManager assetManager = getAssets();
            InputStream in = assetManager.open("tessdata/" + lang + ".traineddata");
            //GZIPInputStream gin = new GZIPInputStream(in);
            OutputStream out = new FileOutputStream(DATA_PATH
                    + "tessdata/" + lang + ".traineddata");

            // Transfer bytes from in to out
            byte[] buf = new byte[1024];
            int len;
            //while ((lenf = gin.read(buff)) > 0) {
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            in.close();
            //gin.close();
            out.close();

            Log.v(TAG, "Copied " + lang + " traineddata");
        } catch (IOException e) {
            Log.e(TAG, "Was unable to copy " + lang + " traineddata " +       e.toString());
        }
    }


    // _image = (ImageView) findViewById(R.id.image);
    _field = (EditText) findViewById(R.id.field);
    _button = (Button) findViewById(R.id.button);
    _button.setOnClickListener(new ButtonClickHandler());

    _path = DATA_PATH + "/ocr.jpg";
}