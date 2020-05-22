public Mat rgba() {
        if (previewFormat == ImageFormat.NV21) {
            Imgproc.cvtColor(mYuvFrameData, mRgba, Imgproc.COLOR_YUV2RGBA_NV21, 4);
        }
        else if (previewFormat == ImageFormat.YV12) {
            Imgproc.cvtColor(mYuvFrameData, mRgba, Imgproc.COLOR_YUV2RGB_I420, 4);  // COLOR_YUV2RGBA_YV12 produces inverted colors
        }
        return mRgba;
    }