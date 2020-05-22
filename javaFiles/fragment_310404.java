// Return type  \/    is double[] instead of double
public static double[] Difference(double ardY[]) {
    double ardDifference[] = new double[5];
    for (int i = 0; i < 5; i++) {
        ardDifference[i] = ardY[i + 1] - ardY[i];
    }
    return ardDifference;//Returns entire array
}