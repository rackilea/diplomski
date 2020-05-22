byte[] yuv = new byte[(int)(mYuv.total()*mYuv.channels())];
    mYuv.get(0,0,yuv);

    MatOfInt rgb = new MatOfInt(CvType.CV_32S);
    mRgba.convertTo(rgb,CvType.CV_32S);
    int[] rgba = new int[(int)(rgb.total()*rgb.channels())];
    rgb.get(0,0,rgba);