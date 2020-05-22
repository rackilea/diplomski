// Decode the JPEG byte array from 'output' to 'Bitmap' object
Bitmap bmp = BitmapFactory.decodeByteArray(output.toByteArray(), 0, output.size());

// Use 'Canvas' to draw text ont 'Bitmap'
Canvas cv = new Canvas(bmp);

// Prepare 'Paint' for text drawing
Paint mPaint = new Paint();
mPaint.setColor( Color.RED );
mPaint.setStyle( Style.STROKE );
mPaint.setTextSize(20);

// Draw text on the 'Bitmap' image
cv.drawText("TEXT To SHOW", 10, 10, mPaint);

// Reset the stream of 'output' for output writing.
output.reset();

// Compress current 'Bitmap' to 'output' as JPEG format
bmp.compress(CompressFormat.JPEG, 95, output);