int[] myIntArray = new int[myarray.length];

for (int i = 0; i < myarray.length; i++) {
    myIntArray[i] = Integer.parseInt(myarray[i]);
}
Collections.sort(myIntArray);