int k = 256;
Random rn = new Random(seed); // use a single Random object, you choose a seed
                              // to get the same sequence, use the same seed

for (int t = 0; t < k; t++) {
    // Random rn = new Random(t); // commented out from your original code
                                  // you only need one Random object
    int randomNumber = rn.nextInt(256); // 256, or whatever you want the max
                                        // value to be
    arrayToBeSorted[t] = randomNumber;
}