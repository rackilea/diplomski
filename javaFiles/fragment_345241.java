private int x;
 private int y;
 private Canvas tempCanvas;
 private Matrix matrix = new Matrix();
 private Path path = new Path();

 animateCircle(){
 Paint myPaint = new Paint();
 myPaint.setAntiAlias(true);
 myPaint.setColor(Color.RED);
 path.addCircle(x, y, 10, Path.Direction.CW);
 //increasing radius of the certain circle 
 matrix.setScale(1.1f, 1.1f, x-5, y-5);
 path.transform(matrix);
 tempCanvas.drawPath(path, myPaint4); 
 }