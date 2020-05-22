Scanner keyboardScanner = new Scanner(System.in); 
double[] array = new double[12]; 
for (int i = 0; i < 12; i++) { 
  System.out.println("Enter Rental for month[" + i + "]");
  array[i] = keyboardScanner.nextDouble();
}

//Declaring the variable totalSum, which holds the total sum of all values in the array.
double totalSum = 0;

//So now, we need to do something with that array and sum up all the values in that array. 
for (int i = 0; i < array.length; i++) {
  System.out.println(array[i]);
}

//Outputting the result of the calculation
System.out.println("The total value is: " + totalSum);