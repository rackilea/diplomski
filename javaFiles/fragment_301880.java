while (counter < n) {
    sum = prevN + nextN;
    prevN = nextN;
    nextN = sum;
    counter++;
}

System.out.println("Fibonacci #" + counter + " is: " + sum);