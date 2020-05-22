int inputi = 12;
int columns = 5;
int iterations = inputi / columns + (inputi % columns > 0 ? 1 : 0);
for (int iter = 0; iter < iterations; iter++) {
    for (int i = 1; i <= 10; i++) {
        for (int j = iter * columns + 1; j <= Math.min(inputi, (iter + 1) * columns); j++) {
            System.out.print(j + " x " + i + " = "  +(i * j) + "\t\t");
        }
        System.out.println();
    }
    System.out.println();
}