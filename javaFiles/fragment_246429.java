Mat srcMat = mats[0];
        if (srcMat == null) {
            exception = new Exception("Cropping Failed");
            errorMessage = "Unable to crop image based on grid";
            return null;
        }
        matProgressTask = srcMat;

        FeatureDetector featureDetector = FeatureDetector.create(FeatureDetector.SIMPLEBLOB);
        featureDetector.read(Environment.getExternalStorageDirectory() + "/Android/blob.xml");
        Log.e("LoadingBlob", "wqfqfwq");
        MatOfKeyPoint matOfKeyPoint = new MatOfKeyPoint();
        featureDetector.detect(srcMat, matOfKeyPoint);
        KeyPoint[] keyPointsArray = matOfKeyPoint.toArray();
        Log.e("keypoints", "" + Arrays.toString(keyPointsArray));
            if (keyPointsArray.length < 1) {
            exception = new Exception("Blobs Missing");
            errorMessage = "Error: Unable to filter blobs";
        } else {
            try {
                MatOfKeyPoint matOfKeyPointFilteredBlobs = new MatOfKeyPoint(keyPointsArray);
                Features2d.drawKeypoints(srcMat, matOfKeyPointFilteredBlobs, srcMat, new Scalar(0, 255, 0), Features2d.DRAW_OVER_OUTIMG);
            } catch (Exception e) {
                e.printStackTrace();
                exception = e;
                errorMessage = "Error: Unable to draw Blobs";
                return null;
            }
            matProgressTask = srcMat;
            onProgressUpdate();
            patterData = pinpointBlobsToGetData(keyPointsArray);
            if (patterData == null) {
                exception = new Exception("Unable to establish pattern");
                errorMessage = "Error: Key points array is null";
            }
        }