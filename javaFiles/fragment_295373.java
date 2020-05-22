System.out.println("Principle: $" + (double) loan);
for (int j = startingYears; j <= endingYears; j+=incrementYears) {
    System.out.printf("Years to repay: %d\n", j);
    System.out.println("-------- -------");
    System.out.println("Rate\tPayment");
    for (double i = startingRate; i <= endingRate; i+=incrementRate){
        int n = 12 * j;
        double c = i / 12.0 / 100.0;
        double payment = loan * c * Math.pow(1 + c, n) / (Math.pow(1 + c, n) - 1); 
        System.out.println(i + "\t" + payment);
    }
    System.out.println();
}