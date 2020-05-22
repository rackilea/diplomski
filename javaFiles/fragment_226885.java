int[] indeces = { 0, 1, 3, 4, 5, 6, 8 };
int[] values = { 18, 19, 20, 21, 22, 23, 24, 25, 26 };
int[] output = new int[indeces.length]

for (int i = 0; i<indeces.length; i++) {
    output[i] = values[indeces[i]];
}