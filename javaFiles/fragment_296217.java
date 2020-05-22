private List<Rect> ListOfRect = new ArrayList<Rect>();

@Override
public boolean onTouch(View arg0,MotionEvent event) {

  double cols = mRgba.cols();
  double rows = mRgba.rows();

  double xOffset = (mOpenCvCameraView.getWidth() - cols) / 2;
  double yOffset = (mOpenCvCameraView.getHeight() - rows) / 2;

  h[i] = (double)(event).getX() - xOffset;
  k[i] = (double)(event).getY() - yOffset;

 h[i]=x;
 k[i]=y;

 ListOfRect.add(new Rect(x-100, y-100, x+100, y+100));

 Log.i(TAG, "Touch image coordinates: (" + h[i] + ", " + k[i] + ")");

 i++;

 return false;// don't need subsequent touch events
}

public Mat onCameraFrame(CvCameraViewFrame inputFrame) {
   mRgba=inputFrame.rgba();

   for(int i=0; i<ListOfRect.size(); i++){
       Core.rectangle(mRgba, ListOfRect.get(i).tl(), ListOfRect.get(i).br(),new Scalar( 0, 0, 255 ),0,8, 0 );}

   return mRgba;
}