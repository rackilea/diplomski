//checks if array is sorted in ascending order
public static boolean isSorted(int[] myList) {
    if(myList == null) return false; //just checking

    for (int i = 0; i < myList.length - 1; i++) {
        if (myList[i] > myList[i + 1]) {
            return false;
        }
    }
    return true;
}