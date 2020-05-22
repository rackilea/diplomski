public Bitmap transform(Bitmap bitmap) {

    Bitmap bitmap2;
    Bitmap bitmap3;

    if (bitmap != null) {


      if (bitmap.getWidth() < MAX_WIDTH) { 
        bitmap = this.scaledDownBitmap(bitmap);
      }


      boolean flag = true;


      int deviceWidth =  ((Activity)this.context).getWindowManager().getDefaultDisplay().getWidth();
      int deviceHeight = ((Activity)this.context).getWindowManager().getDefaultDisplay().getHeight();

      int bitmapHeight = bitmap.getHeight(); // 563
      int bitmapWidth = bitmap.getWidth(); // 900

      // aSCPECT rATIO IS Always WIDTH x HEIGHT rEMEMMBER 1024 x 768

      if (bitmapWidth > deviceWidth) {
        flag = false;

        // scale According to WIDTH
        int scaledWidth = deviceWidth;
        int scaledHeight = (scaledWidth * bitmapHeight) / bitmapWidth;

        try {
          if (scaledHeight > deviceHeight)
            scaledHeight = deviceHeight;

          bitmap2 = Bitmap.createScaledBitmap(bitmap, scaledWidth, scaledHeight, true); //reference the scaled bitmap to local bitmap
          bitmap.recycle(); //recycle the original bitmap

        } catch (Exception e) {
          e.printStackTrace();
        }
      }

      if (flag) {
        if (bitmapHeight > deviceHeight) {
          // scale According to HEIGHT
          int scaledHeight = deviceHeight;
          int scaledWidth = (scaledHeight * bitmapWidth) / bitmapHeight;

          try {
            if (scaledWidth > deviceWidth)
              scaledWidth = deviceWidth;

            bitmap3 = Bitmap.createScaledBitmap(bitmap2, scaledWidth, scaledHeight, true);
            bitmap2.recycle();
            return bitmap3;

          } catch (Exception e) {
            e.printStackTrace();
          }
        }
      }
    }
    return bitmap2;

  }