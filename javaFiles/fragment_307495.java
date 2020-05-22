for (int j = 0; j < 20; j++) {
    System.out.printf("%n%nCycle # %d%n%n%n%n", j);
    for (int i = 1000; i <= 100000; i += 1000) {
        System.out.printf("%9d|%14d|%14d|\n", i, timeLinear(i), timeBinary(i));
    }
}