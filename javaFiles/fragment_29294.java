private void doSomething() {
    long startTimeA = System.currentTimeMillis();
    executeA();
    long endTimeA = System.currentTimeMillis();
    System.out.println("Total Time A: " + (endTimeA - startTimeA));

    long startTimeB = System.currentTimeMillis();
    executeB();
    long endTimeB = System.currentTimeMillis() - startTimeB;
    System.out.println("Total Time B: " + (endTimeB - startTimeB));
}

private void executeA() {
    for(int k=0; k<5; k++) {
        for(int i = 0; i < 40; i++) {
            for(int j = i + 1; j < 40; j++) { 
               double a = methodA();
            }
        }
    }
}

private void executeB() {
    for(int k=0; k<5; k++) {
        for(int i = 0; i < 40; i++) {
            for(int j = i + 1; j < 40; j++) { 
               double b = methodB();
            }
        }
    }
}