for (int i = 2; i <= 100; i++) {
    System.out.print("Factors of " + i + " is: ");
    for (int j = 2; j <= (int) Math.sqrt(i); j++) {
        if (i % j == 0)  System.out.print(j + " " + i / j + " ");
    }
    System.out.println();
}