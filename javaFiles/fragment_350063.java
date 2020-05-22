Parameters cameraParam =  mCamera.getParameters() ;
        double ratio = (double)cameraParam.getPictureSize().height / (double)cameraParam.getPictureSize().width  ;
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        try
        {
            display.getSize(size);
        }
        catch(java.lang.NoSuchMethodError ignore)
        {
            size.x = display.getWidth(); 
            size.y = display.getHeight() ;
        }
        int width = size.y;
        int height = size.x;
        previewParam.width =  width;
        previewParam.height = (int)(previewParam.width / ratio) ;