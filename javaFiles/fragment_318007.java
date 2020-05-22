/** returns minLatitude, maxLatitude, minLongitude, maxLongitude */
public double[] calculateMinMaxValues(double latitude , double longitude, double radius){
    double[] res = new double[4];
    res[0] /*minLatitude*/ = latitude - (radius*2)/60.0;
    res[1] /*maxLatitude*/ = latitude + (radius*2)/60.0;

    res[2] /*minLongitude*/ = (longitude*2)/60.0 *(Math.cos(res[0]));
    res[3] /*maxLongitude*/ = (longitude*2)/60.0 *(Math.cos(res[1]));
    return res;
}