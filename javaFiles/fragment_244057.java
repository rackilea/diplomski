public class CameraActivity extends Activity {

private Camera mCamera;
private CameraPreview mPreview;

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    // Create an instance of Camera
    mCamera = getCameraInstance();

    // Create our Preview view and set it as the content of our activity.
    mPreview = new CameraPreview(this, mCamera);
    FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
    preview.addView(mPreview);
    // Add a listener to the Capture button
    Button captureButton = (Button) findViewById(id.button_capture);
    captureButton.setOnClickListener(
    new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // get an image from the camera
        mCamera.takePicture(null, null, mPicture);
    }
   }
  );
    }
}

 /** A safe way to get an instance of the Camera object. */
 public static Camera getCameraInstance(){
    Camera c = null;
    try {
    c = Camera.open(); // attempt to get a Camera instance
    }
    catch (Exception e){
    // Camera is not available (in use or does not exist)
    }
    return c; // returns null if camera is unavailable
}

private PictureCallback mPicture = new PictureCallback() {

@Override
public void onPictureTaken(byte[] data, Camera camera) {

    File pictureFile = getOutputMediaFile(MEDIA_TYPE_IMAGE);
    if (pictureFile == null){
        Log.d(TAG, "Error creating media file, check storage permissions: " +
            e.getMessage());
        return;
    }

    try {
        FileOutputStream fos = new FileOutputStream(pictureFile);
        fos.write(data);
        fos.close();
    } catch (FileNotFoundException e) {
        Log.d(TAG, "File not found: " + e.getMessage());
    } catch (IOException e) {
        Log.d(TAG, "Error accessing file: " + e.getMessage());
    }
  }
};