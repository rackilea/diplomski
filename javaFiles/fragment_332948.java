public Bitmap getCroppedBitmap (Uri fileUri, int outWidth, int outHeight,
                                    double rl, double rt, double rr, double rb) {
        // rl, rt, rr, rb are relative (values from 0 to 1) to the size of the image.
        // That is because image moving will be smaller than the original.
        if (Build.VERSION.SDK_INT >= 10) {
            // Ensure that device supports at least API level 10
            // so we can use BitmapRegionDecoder
            BitmapRegionDecoder brd;
            try {
                // Again loading from URI. Change the code so it suits yours.
                InputStream is = this.getContentResolver().openInputStream(fileUri);
                brd = BitmapRegionDecoder.newInstance(is, true);

                BitmapFactory.Options options = new BitmapFactory.Options();
                options.outWidth = (int)((rr - rl) * brd.getWidth());
                options.outHeight = (int)((rb - rt) * brd.getHeight());
                options.inSampleSize = calculateInSampleSize(options,
                        outWidth, outHeight);

                return brd.decodeRegion(new Rect(
                        (int) (rl * brd.getWidth()),
                        (int) (rt * brd.getHeight()),
                        (int) (rr * brd.getWidth()),
                        (int) (rb * brd.getHeight())
                ), options);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        else
            return null;
    }