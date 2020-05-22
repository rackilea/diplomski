public void printBin(String soFar, int iterations) {
    if(iterations == 0) {
        System.out.println(soFar);
    }
    else {
        printBin(soFar + "0", iterations - 1);
        printBin(soFar + "1", iterations - 1);
    }
}