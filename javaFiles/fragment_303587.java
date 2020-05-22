Bitmap image1=BitmapUtils.decodeBase64(Lie.GeFondo().GetImagen());
    Bitmap image2=BitmapUtils.getResizedBitmap(BitmapUtils.decodeBase64(Utilidades.getImagenTomadabase64()),Foto.GetTamano().GetWidth(),Foto.GetTamano().GeHeight());
    Bitmap image3=BitmapUtils.getResizedBitmap(BitmapUtils.decodeBase64(Lie.GetBanner().GetImagen()),Lie.GetBanner().GetTamano().GetWidth(),Lie.GetBanner().GetTamano().GeHeight());
    Bitmap result = Bitmap.createBitmap(image1.getWidth(), image1.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas canvas = new Canvas(result);//Create the canvas to your image
    Rect srcRect = new Rect(0, 0, image1.getWidth(), image1.getHeight());
    Rect dstRect = new Rect(srcRect);
    Matrix matrix = new Matrix ();
    Matrix matrix2 = new Matrix ();
    matrix.postTranslate( Foto.GetPosicionDeItems().Getx(),Foto.GetPosicionDeItems().Gety());
    matrix2.postTranslate( Lie.GetBanner().GetPosicionDeItems().Getx(),Lie.GetBanner().GetPosicionDeItems().Gety());
    canvas.drawBitmap(image1, srcRect, dstRect, null);
    dstRect.offset(image1.getWidth(), 0);
    canvas.drawBitmap(image2,matrix , null);
    canvas.drawBitmap(image3,matrix2 , null);