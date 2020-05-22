int[] list = { 1, 2, ..., 5};
calcAverage(list); // We did nothing with the return value... so we lost it
double avg = calcAverage(list); // We assigned the result.. did not lost it :)
// Now we can print the result
System.out.println("The average of all numbers is: \n" + avg);
System.out.println("The average of all numbers is: \n" + calcAverage(list)); // Or printing the result value directly