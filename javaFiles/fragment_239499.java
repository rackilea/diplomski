...
    System.out.println("Histogram of rolls:" ); 
    String star ="*";

    // No point in using "int [] h"

    for (int i=0; i < t.length; i++) {

        // Placing the logic for printing the text inside the loop
        // is how you use arrays
        System.out.print( (i+2) + " : " + t[0] + " times");
        for(int j = 0; j < t[i]; j++) {
           System.out.print(star);
        }
        System.out.println();
    }
}