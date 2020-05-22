int sum = 0, amount = 0, newNumber;
System.out.println("Enter numbers. Enter 999 to stop:");
while ((newNumber = reader.nextInt()) != 999) {
    sum += newNumber;
    amount++;
}
double average = (double)sum / amount;

NumberFormat numfmt = NumberFormat.getInstance();
numfmt.setMinimumFractionDigits(0);
numfmt.setMaximumFractionDigits(9);
numfmt.setGroupingUsed(true);
System.out.println("Sum: " + numfmt.format(sum));
System.out.println("Average: " + numfmt.format(average));