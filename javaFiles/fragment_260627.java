private String getDistanceString(double distance) {
    DecimalFormat df = new DecimalFormat(".#");
    if (Math.abs(distance - Math.round(distance)) < 0.1d) {
        //If value after the decimal point is 0 change the formatting
        df = new DecimalFormat("#");
    }
    return (df.format(distance) + " km").replace(".", ",");
}

public void test() {
    double[] test = {30d, 30.0d, 30.5d, 30.5555d, 30.04d, 1d / 3d};
    for (double d : test) {
        System.out.println("getDistanceString(" + d + ") = " + getDistanceString(d));
    }
}