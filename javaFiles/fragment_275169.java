try {
           FileOutputStream out = new FileOutputStream("/sdcard/test2.png");
           mBitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
        } catch (Exception e) {
           e.printStackTrace();
        }