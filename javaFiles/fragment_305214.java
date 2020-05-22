public static double computePositiveSum(double[] num, int count)
{
    double pos = 0;
    for (int i = 0; i < count; i++) {
        if (num[i] > 0) {
            pos = pos + num[i];
        }
    }
    return pos;
}