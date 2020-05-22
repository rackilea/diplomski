class IntArray {
    int[] myArray;
    public IntArray () {
        myArray = new int[0];
    }
    public IntArray (int [] array) {
        myArray = array;
    }
    /**
     * This method is for accessing the array.
     * The array CAN be modified using this method.
     */
    public int[] getArray() {
        return myArray;
    }
    /**
     * Uses built-in hashCode generating method
     * within the Arrays class.
     * Importing java.util.Arrays is necessary.
     */
    public int hashCode() {
        return Arrays.hashCode(myArray);
    }
    public boolean equals(Object o) {
        if (!(o instanceof IntArray))
            return false;

        //Should use Arrays.equals(o.myArray, myArray);

        if (o.myArray.length != myArray.length)
            return false;
        else {
            for (int i = 0; i < myArray.length; i++) {
                if (myArray[i] != o.myArray[i]) {
                    return false;
                }
            }
            return true;
        }
    }
}