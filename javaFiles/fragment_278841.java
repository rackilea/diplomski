...
Bitmap sourceBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.<your_image>);
Mat sourceMat = new Mat(sourceBitmap.getWidth(), sourceBitmap.getHeight(), CvType.CV_8UC3);
Utils.bitmapToMat(sourceBitmap, sourceMat);

Mat maskMat = new Mat(sourceBitmap.getWidth(), sourceBitmap.getHeight(), CvType.CV_8UC4);
Mat resultMat = new Mat(sourceBitmap.getWidth(), sourceBitmap.getHeight(), CvType.CV_8UC4);

// create color, which added to sourceMat region (+100 - for red channel)
Scalar color = new Scalar(100, 0, 0, 255);

// or you can try Scalar color = new Scalar(10, 20, 30);  as in your question

Point[] region = new Point[4];

// your coords multiplied by 50 for visualization convenience
region[0] = new Point(50, 50);
region[1] = new Point(100, 250);
region[2] = new Point(200, 200);
region[3] = new Point(150, 100);

List<MatOfPoint> contours = new ArrayList();
MatOfPoint regionMat = new MatOfPoint(region);
contours.add(regionMat);

// create mask    
Imgproc.drawContours(maskMat, contours, 0, color, -1);

// apply mask to source
Core.add(maskMat, sourceMat, resultMat);

// just for visualisation
Bitmap bitmap = Bitmap.createBitmap(sourceMat.cols(), sourceMat.rows(), Bitmap.Config.ARGB_8888);
Utils.matToBitmap(resultMat, bitmap);

<your_ImageView>.setImageBitmap(bitmap);
...