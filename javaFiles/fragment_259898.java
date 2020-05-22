public static void main(String args[]) {
    Integer[][] myArray = {{1, 3, 5, 7},{2,4,6,8},{10,20,30,40},{50,60,70,80}};

    // Before flipping  
    printArray(myArray);
    System.out.println();

    // Flip
    flipInPlace(myArray);

    // After flipping
    printArray(myArray);
}

public static void printArray(Object[][] theArray) {
    for(int i = 0; i < theArray.length; i++) {
        for(int j = 0; j < theArray[i].length; j++) {
            System.out.print(theArray[i][j]);
            System.out.print(",");
        }
        System.out.println();
    }
}

// *** THIS IS THE METHOD YOU CARE ABOUT ***
public static void flipInPlace(Object[][] theArray) {
    for(int i = 0; i < (theArray.length / 2); i++) {
        Object[] temp = theArray[i];
        theArray[i] = theArray[theArray.length - i - 1];
        theArray[theArray.length - i - 1] = temp;
    }
}