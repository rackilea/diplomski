public static void searchArray(int[] values, int target){

    //Loop through the array and compare all the elements with the target
    for(int i = 0; i < values.length; i++) {

        //If we find the target, print the success message
        if(values[i] == target) {
            System.out.println("found it at: " + );
            return;  //We can return out of the method
        }
    }

    //If we get down to here, we didn't find the target
    System.out.println("not");

}