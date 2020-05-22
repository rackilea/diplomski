int number = 2;
    int[] binaryFlipped = new int[8];
    for (int i = 0; i < binaryFlipped.length; i++) {
        binaryFlipped[i] = number % 2;
        number = number >> 1;
    }