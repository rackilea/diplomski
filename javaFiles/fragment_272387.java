public class ProfitChooser {

static double MAX_Z = 13.0;
static double MIN_Z = 7.0;
static double Z_INC = 0.9;

static double maxProfit = 0;
static double[] xyArrMax;

public static void main(String[] args) {
    P[] pArr = { new P(4.5,8.5), new P(3.0,7.25), new P(3.5, 4.0), new P(4.5, 3.0) };
    double[] xyArr = new double[pArr.length];


createCombinations(pArr, 0, 0, pArr.length/2, pArr.length/2, 10.0, xyArr);
    System.out.println("Max Profit="+maxProfit);
    for (int i = 0; i<xyArrMax.length; i++)
        System.out.print(xyArrMax[i]+" ");
    System.out.println();
}

private static void createCombinations(P[] pArr, int pos, double profit, int xRem, int yRem, double Z, double[] xyArr) {
    if (pos == pArr.length) {
        if (profit > maxProfit) {
            maxProfit = profit;
            xyArrMax = xyArr;
        }
        return;
    }
    double[] xyArr2 = xyArr.clone();
    if (xRem > 0 && (Z-Z_INC) >= MIN_Z) {
        xyArr2[pos] = pArr[pos].X;
        createCombinations(pArr, pos+1, profit+pArr[pos].X, xRem-1, yRem, Z-Z_INC, xyArr2);
    }
    if (yRem > 0 && (Z+Z_INC) <= MAX_Z) {
        xyArr2[pos] = pArr[pos].Y;
        createCombinations(pArr, pos+1, profit+pArr[pos].Y, xRem, yRem-1, Z+Z_INC, xyArr2);
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