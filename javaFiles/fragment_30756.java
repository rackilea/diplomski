// Determine the length of the array:
int arraylength = 0;
Scanner scan = new Scanner(s).useDelimiter(",");
while(scan.hasNextInt()){
  scan.nextInt(); // Discard the integer
  arraylength++;
}

// Fill the result-array:
int[] intArray = new int[arraylength];
int index = 0;
Scanner scan2 = new Scanner(s).useDelimiter(",");
while(scan2.hasNextInt()){
  intArray[index] = scan2.nextInt();
  index++;
}
return intArray;