public Camera.Size getOptimalPreviewSize(List<Camera.Size> sizes)
    {
        final double ASPECT_TOLERANCE = 0.05;
        if( sizes == null )
            return null;

        Camera.Size optimalSize = null;
        double minDiff = Double.MAX_VALUE;
        Point display_size = new Point();
        Activity activity = (Activity)this.getContext();
        {
            Display display = activity.getWindowManager().getDefaultDisplay();
            display.getSize(display_size);

            Log.d(TAG, "display_size: " + display_size.x + " x " + display_size.y);
        }
        double targetRatio = calculateTargetRatioForPreview(display_size);
        int targetHeight = Math.min(display_size.y, display_size.x);
        if( targetHeight <= 0 ) {
            targetHeight = display_size.y;
        }
        // Try to find the size which matches the aspect ratio, and is closest match to display height
        for(Camera.Size size : sizes)
        {
            Log.d(TAG, "    supported preview size: " + size.width + ", " + size.height);
            double ratio = (double)size.width / size.height;
            if( Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE )
                continue;
            if( Math.abs(size.height - targetHeight) < minDiff ) {
                optimalSize = size;
                minDiff = Math.abs(size.height - targetHeight);
            }
        }
        if( optimalSize == null )
        {
            // can't find match for aspect ratio, so find closest one
            Log.d(TAG, "no preview size matches the aspect ratio");
            optimalSize = getClosestSize(sizes, targetRatio);
        }

            Log.d(TAG, "chose optimalSize: " + optimalSize.width + " x " + optimalSize.height);
            Log.d(TAG, "optimalSize ratio: " + ((double)optimalSize.width / optimalSize.height));
        return optimalSize;
    }


    private double calculateTargetRatioForPreview(Point display_size)
    {
        double targetRatio = 0.0f;

        if( isVideo)
        {

        }
        else
        {
            targetRatio = ((double)mCamera.getParameters().getPictureSize().width) / (double)mCamera.getParameters().getPictureSize().height;
            //targetRatio = ((double)display_size.x) / (double)display_size.y;
        }
        return targetRatio;
    }