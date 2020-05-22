public class SalesPerson {    
    String salesPerson1, salesPerson2;

    public void createSales(AnnualPayCalculator aPC) {
        // you don't need to create aPC
        // AnnualPayCalculator aPC = new AnnualPayCalculator();

        Double[][] sales = new Double[2][2];

        sales[0][0] = aPC.totalSales1;
        sales[0][1] = aPC.totalSales2;
        sales[1][0] = aPC.employee1TotalPay;
        sales[1][1] = aPC.employee2TotalPay;
        printArray(sales);   
    }
}