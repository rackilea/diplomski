public class ProfitChooser {

static double maxProfit = 0;

public static void main(String[] args) {
    P[] pArr = { new P(4.5,8.5), new P(3.0,7.25), new P(3.5, 4.0), new P(4.5, 3.0) };
    createCombinations(pArr, 0, 0, pArr.length/2, pArr.length/2);
    System.out.println("Max Profit="+maxProfit);
}

private static void createCombinations(P[] pArr, int pos, double profit, int xRem, int yRem) {
    if (pos == pArr.length) {
        maxProfit = Math.max(maxProfit, profit);
        return;
    }
    if (xRem > 0)
        createCombinations(pArr, pos+1, profit+pArr[pos].X, xRem-1, yRem);
    if (yRem > 0)
        createCombinations(pArr, pos+1, profit+pArr[pos].Y, xRem, yRem-1);
}

static class P {
    final double X, Y;
    public P(double x, double y) {
        X = x;
        Y = y;
    }
}

}