for (int i = 2; i <= 1000000; i += 2) { //to go through every even integer
    for (int j = 0; j <= i; j++) { 
        for (int k = 0; k <= i; k++) {
                System.out.println("two prime numbers that add to " + i + " are " + array[j] + " and "  + array[k]);
                j = i + 1; // This will end the outer loop as well.
                break;
            }
        }
    }
}