// declare arrays
String[] monthArray = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December" };
double[] monthlySales = new double[12];
getSales(monthArray, monthlySales);
int highestMonth = computeHighestMonth(monthlySales);
int lowestMonth = computeLowestMonth(monthlySales);
double totalSales = computeTotalSales(monthlySales);
double averageSales = computeAverageSales(monthlySales);
double highestSales = monthlySales[highestMonth];
double lowestSales = monthlySales[lowestMonth];