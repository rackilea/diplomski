public static void displayWords(String line) {
    while(line.length() > 0) { // This is the first part (the obvious one)
        /*
           You should do something here that tracks the index of the first space 
           character in the line. I suggest you check the `charAt()` method, and use 
           a for() loop.
           Let's say you find a space at index i
         */
         System.out.println(line.substring(0,i)); // This prints the substring of line
                                                  // that goes from the beginning
                                                  // (index 0) to the position right
                                                  // before the space
         /*
           Finally, here you should assign a new value to line, that value must start
           after the recently found space and end at the end of the line.
           Hint: use substring() again, and remember that line.lengh() will give you
                 the position of the last character of line plus one.
          */
    }
}