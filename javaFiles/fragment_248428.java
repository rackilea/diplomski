int sum = 0;
int indexCounter = 0; // Use this to keep track of the number of 'entries' in the arrays since they may not be perfectly rectangular.
for(int column = 0; column < temps.length; column++) {
    for(int row = 0; row < temps[column].length; row++) {
        sum+= temps[column][row];
        indexCounter++;
    }
}
int average = sum / indexCounter;
System.out.println("The average is " + average);