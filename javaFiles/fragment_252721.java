public static void main(String... args) {
        char[] givenArray = {'o', 't', 'z', 'y', 'e', 's', 'v', 'g', 'r', 'a', 'y', 'e', 's'};

        // this is the initializing function, where you pass 2 params
        // The array and Index from where you want to start looking.  
        where(givenArray, 0);  
        System.out.println("The rightmost occurence of 'yes' in the given array is at index "+ lastFoundIndex);
    }