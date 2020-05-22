private MediaProjectionManager mediaProjectionManager;
private MediaProjection mediaProjection;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) activity.getSystemService(
            android.content.Context.MEDIA_PROJECTION_SERVICE);
    Intent permissionIntent = mediaProjectionManager.createScreenCaptureIntent();
    activity.startActivityForResult(permissionIntent, MEDIA_PROJECTION_REQUEST_CODE);
}

public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    if (MEDIA_PROJECTION_REQUEST_CODE == requestCode) {
        if (resultCode == RESULT_OK) {
            mediaProjectionManager = (MediaProjectionManager) getSystemService(
                    android.content.Context.MEDIA_PROJECTION_SERVICE);
            mediaProjection = mediaProjectionManager.getMediaProjection(resultCode, intent);
            startRecording(mediaProjection);
        }
    }
}

public void startRecording(MediaProjection mediaProjection) {
    DisplayManager dm = (DisplayManager) activity.getSystemService(Context.DISPLAY_SERVICE);
    Display defaultDisplay = null;
    if (dm != null) {
        defaultDisplay = dm.getDisplay(Display.DEFAULT_DISPLAY);
    }
    if (defaultDisplay == null) {
        return;
    }

    DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
    int screenWidth = metrics.widthPixels;
    int screenHeight = metrics.heightPixels;
    int screenDensity = metrics.densityDpi;

    Surface inputSurface = copy.getHolder().getSurface();

    mediaProjection.createVirtualDisplay("Recording Display", screenWidth,
            screenHeight, screenDensity, DisplayManager.VIRTUAL_DISPLAY_FLAG_AUTO_MIRROR, inputSurface,
            null, null);
}