// integers by value
int n = in.nextInt();
int evenNumber = 0, oddNumber = 0, count = 0, total = 0;
int largest = n, smallest = n;
// start of loop
while (true) {
    n = in.nextInt();
    // end loop method
    if (n == 0) {
        break;
    }
    total += n;
    count++;
    // count of even numbers
    if (n % 2 == 0) {
        evenNumber++;
    } else {
        oddNumber++;
    }
    largest = Math.max(n, largest);
    smallest = Math.min(n, smallest);
}
System.out.println("Total number of integers entered is: " + count);
System.out.println("Total even numbers entered: " + evenNumber);
System.out.println("Total odd numbers entered: " + oddNumber);
System.out.println("The largest integer: " + largest);
System.out.println("The smallest integer: " + smallest);
double average = total / (double) count;
System.out.println("The average value is: " + average);