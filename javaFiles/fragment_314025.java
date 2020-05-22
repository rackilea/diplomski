public static void displayWords(String line) {
    int i; // You'll need this
    while(line.length() > 0) { // This is the first part (the obvious one)
        /*
           Here, check each character and if you find a space, break the loop
         */
        for(i = 0; i < line.length(); i++) {
            if(line.charAt(i) == ' ') // If the character at index i is a space ...
                break;                // ... break the for loop
        }
        System.out.println(line.substring(0,i)); // This prints the substring of line
                                                 // that goes from the beginning
                                                 // (index 0) to the position right
                                                 // before the space
        /*
          Here, the new value of line is the substring from the position of the space
          plus one to the end of the line. If i is greater than the length of the line
          then you're done.
         */
        if(i < line.length())
            line = line.substring(i + 1, line.length());
        else
            line = "";
    }
}