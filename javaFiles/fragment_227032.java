int value[] = new int[20];
int value2[] = new int[20];
Random randomNumbers = new Random();

for (int j = 0; j < 20; j++) {
    value[j] = randomNumbers.nextInt(201);
}
Arrays.sort(value);
int k = 0;
for (int j = 0; j < 20; j++) {
    if (value[j] > 30) {
    value2[k] = value[j];

    System.out.println(value2[k]);
    k++;
    }
}