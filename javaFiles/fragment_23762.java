public class Calculations {

     double TotalSales;      
     double ComRate = 0.025;         
     double AnnualSal = 80000;       
     double compensation;
     double SalesTarget;
     double Acceleration = 1.5;
     double chart;
     double ComAccFactor;

    public double getCommissionNotifications() {
         if (TotalSales > 120000){
             return AnnualSal  + (TotalSales * (ComRate + Acceleration));
         } else if (TotalSales > SalesTarget * .8) {
             return AnnualSal + (TotalSales * ComRate);
         } else {
             return AnnualSal;
         }
    }

    // Not sure why this is needed... You have a dynamic getter method

    //public void setCommissionNotifications(double commissionNotifications) {
    //    CommissionNotifications = commissionNotifications;
    //}
}