public static double getScaleFactor(int iMasterSize, int iTargetSize) {

    double dScale = 1;
    if (iMasterSize > iTargetSize) {

        dScale = (double) iTargetSize / (double) iMasterSize;

    } else {

        dScale = (double) iTargetSize / (double) iMasterSize;

    }

    return dScale;

}