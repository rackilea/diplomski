String stock = "";
double sum = 0.0;
System.out.println("Enter Stock Price of Last 5 days, then enter 'done' when finished: ");

while(!(stock = input.nextLine()).equalsIgnoreCase("done")) {
    double stockValue = Double.parseDouble(stock );
    sum += stockValue;
}