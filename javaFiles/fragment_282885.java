MatOfRect faces = new MatOfRect();

    if (mDetectorType == JAVA_DETECTOR) {
        if (mJavaDetector != null)
            mJavaDetector.detectMultiScale(mGray, faces, 1.1, 2, 2, // TODO: objdetect.CV_HAAR_SCALE_IMAGE
                    new Size(mAbsoluteFaceSize, mAbsoluteFaceSize), new Size());
    }
    else if (mDetectorType == NATIVE_DETECTOR) {
        if (mNativeDetector != null)
            mNativeDetector.detect(mGray, faces);
        }
    else {
        Log.e(TAG, "Detection method is not selected!");
    }

    Rect[] facesArray = faces.toArray();
    for (int i = 0; i < facesArray.length; i++)
        Imgproc.rectangle(mRgba, facesArray[i].tl(), facesArray[i].br(), FACE_RECT_COLOR, 3);