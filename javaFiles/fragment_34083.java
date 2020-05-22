public class FaceDetection  extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new myView(this));
    }

    private class myView extends View {

        private int imageWidth, imageHeight;
        private int numberOfFace = 5;
        private FaceDetector myFaceDetect;
        private FaceDetector.Face[] myFace;
        float myEyesDistance;
        int numberOfFaceDetected;

        Bitmap myBitmap;

        public myView(Context context) {
            super(context);

            BitmapFactory.Options BitmapFactoryOptionsbfo = new BitmapFactory.Options();
            BitmapFactoryOptionsbfo.inPreferredConfig = Bitmap.Config.RGB_565;
            myBitmap = BitmapFactory.decodeResource(getResources(),
                    R.drawable.jorgesys, BitmapFactoryOptionsbfo);
            imageWidth = myBitmap.getWidth();
            imageHeight = myBitmap.getHeight();
            myFace = new FaceDetector.Face[numberOfFace];
            myFaceDetect = new FaceDetector(imageWidth, imageHeight,
                    numberOfFace);
            numberOfFaceDetected = myFaceDetect.findFaces(myBitmap, myFace);

        }

        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawBitmap(myBitmap, 0, 0, null);
            Paint myPaint = new Paint();
            myPaint.setColor(Color.GREEN);
            myPaint.setStyle(Paint.Style.STROKE);
            myPaint.setStrokeWidth(3);
            for (int i = 0; i < numberOfFaceDetected; i++) {
                Face face = myFace[i];
                PointF myMidPoint = new PointF();
                face.getMidPoint(myMidPoint);
                myEyesDistance = face.eyesDistance();

                canvas.drawRect((int) (myMidPoint.x - myEyesDistance * 2),
                        (int) (myMidPoint.y - myEyesDistance * 2),
                        (int) (myMidPoint.x + myEyesDistance * 2),
                        (int) (myMidPoint.y + myEyesDistance * 2), myPaint);
            }
        }
    }
}