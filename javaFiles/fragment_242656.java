// make a copy of the first section before overwriting it
int[] copy = Arrays.copyOfRange (inputArray, from, to);
// overwrite the first section with the second section
System.arraysCopy(inputArray, sourcePosition, inputArray, from, copy.length);
// copy the original content of the first section to the second section
System.arraysCopy(copy, 0, inputArray, sourcePosition, copy.length);