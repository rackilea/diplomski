public static void main(String[] args) {
    double a[][] = new double[9][9];
    for (int i = 0; i < 9; i++)
        a[i][i] = 1;

    SimpleRegression r = new SimpleRegression(true);

    addData(r, a);

    System.out.println("Slope = " + r.getSlope());
    System.out.println("Intercept = " + r.getIntercept());
}

public static void addData(SimpleRegression r, double[][] data) {
    for(int x=0; x<data.length; x++) {
        for(int y=0; y<data[0].length; y++) {
            for(int i=0; i<data[x][y]; i++) {
                r.addData(x, y);
            }
        }
    }
}