private Camera.Size getOptimalSize(List<Camera.Size> sizes, int h, int w) {
    final double ASPECT_TOLERANCE = 0.05;
    double targetRatio = (double) w/h;

    if (sizes == null) {
        return null;
    }

    Camera.Size optimalSize = null;

    double minDiff = Double.MAX_VALUE;

    int targetHeight = h;

    for (Camera.Size size : sizes) {
        double ratio = (double) size.width / size.height;
        if (Math.abs(ratio - targetRatio) > ASPECT_TOLERANCE) continue;
        if (Math.abs(size.height - targetHeight) < minDiff) {
            optimalSize = size;
            minDiff = Math.abs(size.height - targetHeight);
        }
    }

    if (optimalSize == null) {
        minDiff = Double.MAX_VALUE;
        for (Camera.Size size : sizes) {
            if (Math.abs(size.height - targetHeight) < minDiff) {
                optimalSize = size;
                minDiff = Math.abs(size.height - targetHeight);
            }
        }
    }

    return optimalSize;
}