System.out.println("Enter the sales tax: ");
double salesTax = keybd.next();

double totalTax =0.0;
double total = 0.0;

for(int indexc=0; indexc < costArray.length; indexc++){
System.out.println("Enter the item cost: ");
double cost = Double.valueOf(keybd.next()).doubleValue();
totalTax = totalTax + (cost * salesTax);
total = total + cost;
}

System.out.println("Total: " + (total-totalTax));