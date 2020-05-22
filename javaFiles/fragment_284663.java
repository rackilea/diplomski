Mat lines = new Mat();
    int threshold = 70;
    int minLineSize = 30;
    int lineGap = 10;

    Imgproc.HoughLinesP(thresholdImage, lines, 1, Math.PI / 180, threshold,
            minLineSize, lineGap);

    for (int x = 0; x < lines.cols(); x++) {

        double[] vec = lines.get(0, x);
        double[] val = new double[4];

        val[0] = 0;
        val[1] = ((float) vec[1] - vec[3]) / (vec[0] - vec[2]) * -vec[0] + vec[1];
        val[2] = src.cols();
        val[3] = ((float) vec[1] - vec[3]) / (vec[0] - vec[2]) * (src.cols() - vec[2]) + vec[3];

        lines.put(0, x, val);

    }