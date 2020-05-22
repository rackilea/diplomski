int array[] = {2, 4, 9};
Scanner ethan = new Scanner(System.in);

/**
 * This gets one valid number from the user
 */
public void getOneNumber() {
    /**
     * This is our "switch" variable
     */
    boolean validIndexGiven = false;

    while (!validIndexGiven)

    {
        /** This is actually called "array index"*/
        System.out.println("Enter array index: 0 to " + (array.length - 1));
        int index = ethan.nextInt();

        /** Here we check if given integer is in the bounds of array.
         * No need to check every possible value.
         * What if we had array[100]? */
        if (index >= 0 && index < array.length) {
            /** Amount was a valid number. */
            System.out.println(array[index]);
            /** Toggling the switch */
            validIndexGiven = true;
        }
    }
}

/**
 * This prompts the user for numbers as many times as there are elements in array
 */
public void getManyNumbers() {
    int length = array.length;
    for (int i = 0; i < length; i++) {
        getOneNumber();
    }
}