if (n >= 2) {
    counter = 2;
    prevN = 1;
    nextN = 2;

    while (counter < n) {
        sum = prevN + nextN;
        prevN = nextN;
        nextN = sum;
        counter++;
    }

    System.out.println("Fibonacci #" + counter + " is: " + sum);
} else {
    System.out.println("Invalid Input. Please Try Again.");
}