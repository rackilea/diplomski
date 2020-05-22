/* Is feet greater than 3 and less than 8 (4 to 7) and 
   is inches 0 or greater and less than 12   */
If (heightFeet > 3 && heightFeet < 8 && heightIn >= 0.0d && heightIn <= 11.9375d) {
    // All is Good!
    pass = true;    // set to true so as to exit the while loop.
}
else {
    // Hmmm....something's not right.
    System.out.println("The height supplied (" + hightFeet + " " + 
             heightIn + ") is invalid! Try again:");
}