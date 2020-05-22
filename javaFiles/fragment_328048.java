private void merge(Mat background, Mat overlay) {
            List<Mat> backgroundChannels = new ArrayList<>();
            Core.split(background, backgroundChannels);

        List<Mat> overlayChannels = new ArrayList<>();
        Core.split(overlay, overlayChannels);

        // compute "alphaRate = 1 - overlayAlpha / 255"
        Mat overlayAlphaChannel = overlayChannels.get(3);
        Mat alphaRate = new Mat(overlayAlphaChannel.size(), overlayAlphaChannel.type());
        Core.divide(overlayAlphaChannel, new Scalar(255), alphaRate);
        Core.absdiff(alphaRate, new Scalar(1), alphaRate);

        for (int i = 0; i < 3; i++) {
            // compute "(1 - alphaRate) * overlay"
            Mat overlayChannel = overlayChannels.get(i);
            Mat temp = new Mat(alphaRate.size(), alphaRate.type());
            Core.absdiff(alphaRate, new Scalar(1), temp);
            Core.multiply(temp, overlayChannel, overlayChannel);
            temp.release();

            // compute "background * alphaRate"
            Mat backgroundChannel = backgroundChannels.get(i);
            Core.multiply(backgroundChannel, alphaRate, backgroundChannel);

            // compute the merged channel
            Core.add(backgroundChannel, overlayChannel, backgroundChannel);
        }

        alphaRate.release();
        Core.merge(backgroundChannels, background);
    }