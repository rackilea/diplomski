public class Sales {

private String[] months;
private String[] cities;
private int[] citySum;
private int[] monthlySum;
private int[][] sales;
private int col;
private int row;


/**
 * @param args the command line arguments
 */
public static void main(String[] args) {
    Sales salesObj = new Sales();
    salesObj.calCityTotal();
    salesObj.calMonthlyTotal();

}

public Sales() {


    months = new String[]{"January", "Febuary", "March", "April",
            "May", "June"};

    cities = new String[]{"Chilliwack", "Kamloops", "Kelowna",
            "NanaimoSurrey", "Vancouver", "Victoria"};

    sales = new int[][]{{400, 500, 500, 600, 500, 600},
            {600, 800, 800, 800, 900, 900},
            {700, 700, 700, 900, 900, 1000},
            {500, 600, 700, 800, 700, 700},
            {900, 900, 900, 1000, 1100, 1100}};

    citySum = new int[sales.length+1];

    monthlySum = new int[sales[0].length];
}

public void calCityTotal() {

    for (row = 0; row < sales.length; row++) {
        for (col = 0; col < sales[0].length; col++) {
            citySum[col] += sales[row][col];
        }
    }
}

public void calMonthlyTotal() {

    for (row = 0; row < sales.length; row++) {
        for (col = 0; col < sales[0].length; col++) {
            monthlySum[row] += sales[row][col];
        }
    }
}