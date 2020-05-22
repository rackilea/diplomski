String[] strArray = s.split(",");
int arrayLength = strArray.length;
int[] intArray = new int[arrayLength];
for(int index = 0; index < arrayLength; index++){
  // No need to try-catch the ParseException, since we already validated the String above
  intArray[index] = Integer.parseInt(strArray[index]);
}
return intArray;