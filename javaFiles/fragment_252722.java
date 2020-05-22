public static void where(char[] arr, int startIndex) {
        // this is the base case. First statement. 
        // Basically for testing, if the array is empty or we reached at the end of the execution (we'll reach there soon)
        if(startIndex >= arr.length) {
            return;
        }

        // Now we check if we have the word 'yes', if so - save the lastFoundIndex. and call where function and tell it to look starting from currentIndex + 3 place.  
        if(arr[startIndex] == 'y' && startIndex + 2 < arr.length) {
            if(arr[startIndex + 1] == 'e' && arr[startIndex + 2] == 's') {
                lastFoundIndex = startIndex;
                where(arr, startIndex+3);
            }
        }

        // if we dont find the character y, then just go on with next char.  
        where(arr, startIndex+1);
    }