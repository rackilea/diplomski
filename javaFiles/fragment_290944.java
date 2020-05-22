/**
  * Returns the area under the normal curve between the z-scores z1 and z2
  */
double getAreaUnderNormalCurve(double z1, double z2) {
    double area = 0.0;
    final int rectangles = 100000; // more rectangles = more precise, less rectangles = quicker execution
    final double width = (z2 - z1) / rectangles;
    for(int i = 0; i < rectangles; i++)
        area += width * getNormalProbabilityAtZ(width * i + z1);
    return area;
}