protected static double fromCMToPPI(double cm) {
    return toPPI(cm * 0.393700787);
}

protected static double toPPI(double inch) {
    return inch * 72d;
}