public static double getScaleFactorToFit(Dimension original, Dimension toFit) {

    double dScale = 1d;

    if (original != null && toFit != null) {

        double dScaleWidth = getScaleFactor(original.width, toFit.width);
        double dScaleHeight = getScaleFactor(original.height, toFit.height);

        dScale = Math.min(dScaleHeight, dScaleWidth);

    }

    return dScale;

}

public static double getScaleFactorToFill(Dimension masterSize, Dimension targetSize) {

    double dScaleWidth = getScaleFactor(masterSize.width, targetSize.width);
    double dScaleHeight = getScaleFactor(masterSize.height, targetSize.height);

    double dScale = Math.max(dScaleHeight, dScaleWidth);

    return dScale;

}