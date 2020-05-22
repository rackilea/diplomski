int k = 256;
Random rn = new Random(seed);

for (int c = 0; c < 10; c++) {
    for (int t = 0; t < k; t++) {
        int randomNumber = rn.nextInt(256);
        someArrayOfTenArrays[c][t] = randomNumber;
    }
}