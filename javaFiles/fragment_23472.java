double[] numbers = new double[10];
Random random = new Random();
for (int i = 0; i < 10; i++) {
    numbers[i] = 0.5 + (random.nextInt(8)) * 0.5;
    System.out.println(numbers[i]);
}