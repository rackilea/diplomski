public class ProfitChooser2 {

static double Z_START = 10.0;
static double Z_END = 13.0;
static double Z_INC = 1.5;

static double maxProfit = 0;
static double[] xyArrMax;

public static void main(String[] args) {
    P[] pArr = { new P(4.5,8.5), new P(3.0,7.25), new P(3.5, 4.0), new P(4.5, 3.0) };
    double[] xyArr = new double[pArr.length];
    createCombinations(pArr, 0, 0.0, Z_START, pArr.length, xyArr);
    System.out.println("Max Profit="+maxProfit);
    for (int i = 0; i<xyArrMax.length; i++)
        System.out.print(xyArrMax[i]+" ");
    System.out.println();
}

private static void createCombinations(P[] pArr, int pos, double profit, double Z, int rem, double[] xyArr) {

    if (rem == 0) {
        if (profit > maxProfit) {
            maxProfit = profit;
            xyArrMax = xyArr;
        }
        return;
    }
    double[] xyArr2 = xyArr.clone();

    double MAX_Z_DELTA = (rem-1)*Z_INC; // This is the largest delta allowed at this iteration (based on rem)

    double MAX_Z = Z_END+MAX_Z_DELTA;   // Can't go over this amount, or will not be able to return to Z_END in time
    double MIN_Z = Z_END-MAX_Z_DELTA;   // Can't go below this amount, or will not be able to return to Z_END in time

    if (Z-Z_INC >= MIN_Z) {
        xyArr2[pos] = pArr[pos].X;
        createCombinations(pArr, pos+1, profit+pArr[pos].X, Z-Z_INC, rem-1, xyArr2);
    }
    if (Z+Z_INC <= MAX_Z) {
        xyArr2[pos] = pArr[pos].Y;
        createCombinations(pArr, pos+1, profit+pArr[pos].Y, Z+Z_INC, rem-1, xyArr2);
    }
}

static class P {
    final double X, Y;
    public P(double x, double y) {
        X = x;
        Y = y;
    }
}

}