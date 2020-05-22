int[] myList = {6, 2, 9, 40, 1};
int lowestNum = Integer.MAX_VALUE;
for (int i = 0; i<myList.length; i++) {
    if (lowestNum > myList[i]) {
        lowestNum = myList[i];
    }
}