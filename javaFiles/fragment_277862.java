public Mat onCameraFrame(Mat aInputFrame) {
        Imgproc.cvtColor(aInputFrame, grayscaleImage, Imgproc.COLOR_RGBA2RGB);

        MatOfRect faces = new MatOfRect();

        if (cascadeClassifier != null) {
            cascadeClassifier.detectMultiScale(grayscaleImage, faces, 1.1, 2, 2,
                    new Size(absoluteFaceSize, absoluteFaceSize), new Size());
        }

        if(faces.empty())
            return aInputFrame;

        ArrayList<MatOfPoint2f> landmarks = new ArrayList<MatOfPoint2f>();
        fm.fit(grayscaleImage, faces, landmarks)
      ...
        return aInputFrame;
    }