intNumberOfValues = Integer.parseInt(strNumberOfValues);
int[] intArray = new int[intNumOfValues];
for (int i = 0; i < intNumberOfValues; i++) {
    System.out.println("Please enter value for index value of " + i);
    strValue = input.nextLine();
    intArray[i] = Integer.parseInt(strValue);
}
System.out.println("Here is the unsorted list: \n" + Arrays.toString(intArray));
. . .