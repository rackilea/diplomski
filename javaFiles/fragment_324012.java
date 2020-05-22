package com.example.stemmeriky.testapplication;
//imports 

public class MainActivity_show_camera_service extends Service  {
private List<MatOfPoint> contours;
private int mWidth = 480;
private int mHeight = 320;
private Mat mFGMask;
private BackgroundSubtractorMOG2 fgbg;
private Handler mCameraHandler;
private static int counter = 0;
private ImageReader mImageReader = ImageReader.newInstance(mWidth, mHeight, ImageFormat.YUV_420_888, 2);
public int threshold = 650;
private Surface mCameraRecieverSurface = mImageReader.getSurface();


private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
    @Override
    public void onManagerConnected(int status) {
        switch (status) {
            case LoaderCallbackInterface.SUCCESS: {
                fgbg = Video.createBackgroundSubtractorMOG2();
                contours = new ArrayList<>();
            }
            break;
            default: {
                super.onManagerConnected(status);
            }
            break;
        }
    }
};

public void convertImageToMat(Mat inputFrame) throws FileNotFoundException {
    contours.clear();
    fgbg.apply(inputFrame, mFGMask, 0.1);
    Imgproc.findContours(mFGMask, contours, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_NONE);

    if (contours.size() > threshold) {
        System.out.println("movement detected");//           
savePicture(inputFrame);
    }
}


public static Mat imageToMat(Image image) {
    ByteBuffer buffer;
    int rowStride;
    int pixelStride;
    int width = image.getWidth();
    int height = image.getHeight();
    int offset = 0;

    Image.Plane[] planes = image.getPlanes();
    byte[] data = new byte[image.getWidth() * image.getHeight() * ImageFormat.getBitsPerPixel(ImageFormat.YUV_420_888) / 8];
    byte[] rowData = new byte[planes[0].getRowStride()];

    for (int i = 0; i < planes.length; i++) {
        buffer = planes[i].getBuffer();
        rowStride = planes[i].getRowStride();
        pixelStride = planes[i].getPixelStride();
        int w = (i == 0) ? width : width / 2;
        int h = (i == 0) ? height : height / 2;
        for (int row = 0; row < h; row++) {
            int bytesPerPixel = ImageFormat.getBitsPerPixel(ImageFormat.YUV_420_888) / 8;
            if (pixelStride == bytesPerPixel) {
                int length = w * bytesPerPixel;
                buffer.get(data, offset, length);

                // Advance buffer the remainder of the row stride, unless on the last row.
                // Otherwise, this will throw an IllegalArgumentException because the buffer
                // doesn't include the last padding.
                if (h - row != 1) {
                    buffer.position(buffer.position() + rowStride - length);
                }
                offset += length;
            } else {

                // On the last row only read the width of the image minus the pixel stride
                // plus one. Otherwise, this will throw a BufferUnderflowException because the
                // buffer doesn't include the last padding.
                if (h - row == 1) {
                    buffer.get(rowData, 0, width - pixelStride + 1);
                } else {
                    buffer.get(rowData, 0, rowStride);
                }

                for (int col = 0; col < w; col++) {
                    data[offset++] = rowData[col * pixelStride];
                }
            }
        }
    }

    // Finally, create the Mat.
    Mat mat = new Mat(height + height / 2, width, CvType.CV_8UC1);
    mat.put(0, 0, data);

    return mat;
}

public void savePicture(Mat image) throws FileNotFoundException {
    File storage = Environment.getExternalStorageDirectory();
    File RobotPhotoDirectory = new File(storage + "/Pictures/RobotPhotoDirectory/");
    if (!RobotPhotoDirectory.exists()) {
        RobotPhotoDirectory.mkdir();
    }
    String dir_path = RobotPhotoDirectory + "/";
    Imgcodecs.imwrite(dir_path + File.separator + "testfile" + counter + ".jpg", image);
    counter++;
}

ImageReader.OnImageAvailableListener mImageAvailListener = new ImageReader.OnImageAvailableListener() {
    @Override
    public void onImageAvailable(ImageReader reader) {
        Image image = reader.acquireLatestImage();
        try {
            convertImageToMat(imageToMat(image));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        image.close();
    }
};

{
    mImageReader.setOnImageAvailableListener(mImageAvailListener, mCameraHandler);
}

MainActivity_show_camera_service() {
    HandlerThread mCameraHandlerThread = new HandlerThread("mCameraHandlerThread");
    mCameraHandlerThread.start();
    mCameraHandler = new Handler(mCameraHandlerThread.getLooper());
}

@SuppressLint("MissingPermission")
public void startProducing() {
    CameraManager cm = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
    try {
        String[] cameraList = cm.getCameraIdList();
        for (String cd : cameraList) {
            CameraCharacteristics mCameraCharacteristics = cm.getCameraCharacteristics(cd);
            if (mCameraCharacteristics.get(CameraCharacteristics.LENS_FACING) != CameraCharacteristics.LENS_FACING_FRONT) {
                continue;
            }
            cm.openCamera(cd, mDeviceStateCallback, mCameraHandler);
        }
    } catch (CameraAccessException e) {
        e.printStackTrace();
    }
}


private final CameraDevice.StateCallback mDeviceStateCallback = new CameraDevice.StateCallback() {
    @Override
    public void onOpened(@NonNull CameraDevice camera) {
        List<Surface> surfaceList = new ArrayList<>();
        surfaceList.add(mCameraRecieverSurface);

        try {
            camera.createCaptureSession(surfaceList, mCaptureSessionStateCallback, mCameraHandler);
        } catch (CameraAccessException ignored) {
        }
    }
    @Override
    public void onDisconnected(@NonNull CameraDevice camera) {
    }
    @Override
    public void onError(@NonNull CameraDevice camera, int error) {

    }
};


public void onCreate() {
    System.out.println("onCreate");
    super.onCreate();
    if (!OpenCVLoader.initDebug()) {
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, mLoaderCallback);
    } else {
        mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
    }
    mFGMask = new Mat();
    startProducing();
}


@Nullable
@Override
public IBinder onBind(Intent intent) {
    return null;
}

private final CameraCaptureSession.StateCallback mCaptureSessionStateCallback = new CameraCaptureSession.StateCallback() {
    @Override
    public void onConfigured(@NonNull CameraCaptureSession session) {
        try {
            CaptureRequest.Builder requestBuilder = session.getDevice().createCaptureRequest(CameraDevice.TEMPLATE_RECORD);
            requestBuilder.addTarget(mCameraRecieverSurface);
            //set to null - image data will be produced but will not receive metadata
            session.setRepeatingRequest(requestBuilder.build(), null, mCameraHandler);

        } catch (CameraAccessException e) {
        }
    }

    @Override
    public void onConfigureFailed(@NonNull CameraCaptureSession session) {
    }
};