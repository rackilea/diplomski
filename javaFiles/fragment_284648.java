Bitmap bmp = BitmapFactory.decodeFile(filePath);
    Bitmap alteredBitmap = Bitmap.createBitmap(bmp.getWidth(), bmp.getHeight(), bmp.getConfig());
    Canvas canvas = new Canvas(alteredBitmap);
    Paint paint = new Paint();
    ColorMatrix cm = new ColorMatrix();
    cm.setSaturation(progress2);
    paint.setColorFilter(new ColorMatrixColorFilter(cm));
    Matrix matrix = new Matrix();
    canvas.drawBitmap(bmp, matrix, paint);

Bitmap resizedBitmap = Bitmap.createBitmap(alteredBitmap, 0, 0, 3264, 2448);
File file = new File(sdcard+"/DCIM/Camera/image3.jpg");
try {
    file.createNewFile();
    FileOutputStream ostream = new FileOutputStream(file);
    resizedBitmap.compress(CompressFormat.JPEG, 100, ostream);
    ostream.close();
    } catch (Exception e) 
        {
        System.out.println("WRITING HAS FAILED");
        e.printStackTrace();
        }