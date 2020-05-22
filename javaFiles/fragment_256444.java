Options options = new BitmapFactory.Options();
  options.inJustDecodeBounds = true;

  BitmapFactory.decodeStream(is, null, options);

  Boolean scaleByHeight = Math.abs(options.outHeight - TARGET_HEIGHT) >= Math.abs(options.outWidth - TARGET_WIDTH);

  if(options.outHeight * options.outWidth * 2 >= 200*200*2){
         // Load, scaling to smallest power of 2 that'll get it <= desired dimensions
        double sampleSize = scaleByHeight
              ? options.outHeight / TARGET_HEIGHT
              : options.outWidth / TARGET_WIDTH;
        options.inSampleSize = 
              (int)Math.pow(2d, Math.floor(
              Math.log(sampleSize)/Math.log(2d)));
     }

        // Do the actual decoding
        options.inJustDecodeBounds = false;

        is.close();
        is = getHTTPConnectionInputStream(sUrl);
        Bitmap img = BitmapFactory.decodeStream(is, null, options);
        is.close();