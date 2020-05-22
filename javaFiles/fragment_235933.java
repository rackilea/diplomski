public class QuickTester {

    public static void main(String[] args) {

        double [][] data= {{97, 36, 79}, {94, 74, 60},
                {68, 76, 58}, {64, 87, 56}, {68, 27, 73},
                {74, 99, 42}, {7, 93, 87}, {51, 69, 40},
                {38, 23, 33}, {57, 86, 31}};

        double [] xArr = new double[data.length];
        double [] yArr = new double[data.length];
        double [] bubbleSizeArr = new double[data.length];

        for(int i = 0; i < data.length; i++) {
            xArr[i] = data[i][0];
            yArr[i] = data[i][1];
            bubbleSizeArr[i] = data[i][2];
        }

        // Test printing
        for(int i = 0; i < data.length; i++) {
            System.out.printf("%5.2f %5.2f %5.2f%n", xArr[i],
                    yArr[i], bubbleSizeArr[i]);
        }
    }
}