opponentImageChannels.add(new Mat(mReferenceBGRImage.size(), CvType.CV_32FC1));
    opponentImageChannels.add(new Mat(mReferenceBGRImage.size(), CvType.CV_32FC1));
    opponentImageChannels.add(new Mat(bgrImage.size(), CvType.CV_32FC1));

    for (int y = 0; y < bgrImage.rows(); ++y) {
        for (int x = 0; x < bgrImage.cols(); ++x) {

            double[] data = bgrImage.get(y, x);

            double b = data[0];
            double g = data[1];
            double r = data[2];

            opponentImageChannels.get(0).put(y, x, 0.5f * (255 + g + r));
            opponentImageChannels.get(1).put(y, x, 0.25 * (510 + r + g - 2 * b));
            opponentImageChannels.get(2).put(y, x, 0.5f * 1.0f / 3.0f * (r + g + b));


             }