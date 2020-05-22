int x           = (videoWidth - imageWidth) / 2;
    int y           = (videoHeight - imageHeight) / 2;
    CropImageFilter cropFilter = new CropImageFilter
            (x, y, imageWidth, imageHeight);
    Image croppedImage = toolkit.createImage(new FilteredImageSource
            (image.getSource(), cropFilter));