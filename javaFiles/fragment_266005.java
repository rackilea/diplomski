for (int i = 0; i < lengde; ) {
  int readInt = keyboard.nextInt();
  boolean found = false;
  for(int index=0; index < i; index++) {
    intFromArray = myArray[index]; // Get element from array
    if(readInt == intFromArray) {
      found = true; // Number already in array
      break;
    }
  }
  // Number not found in the array. Add it to the array.
  if(!found) {
    myArray[i] = readInt;
    i++;
  } else {
       System.out.println("Found in array. Try again...");
  }

}