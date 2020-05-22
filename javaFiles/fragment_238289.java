int counter = 5;
for (int line = 0; line < 3; line++)  {
    for (int column = 0; column < line + 1; column++) {
        System.out.print(counter);  // print the current counter
        System.out.print(" ");      // print a space between each number
        counter--;                  // decrease the counter by 1
    }
    System.out.println();  // go to the next line
}