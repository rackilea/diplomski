int amount = 287;

int[] values = new int[]{25, 20, 5, 1}; // The values of my coins
int[] results = new int[values.length];

for (int i = 0; i < values.length; i++) {
    int valueOfCoin = values[i];
    int numberOfCoins = amount / valueOfCoin; // Division gives the integer part of the result
    results[i] = numberOfCoins;

    amount = amount % valueOfCoin; // Modulo gives the remainder part of the result
    // Or you could simply write: amount %= valueOfCoin;
}

System.out.println("RESULTS=" + Arrays.toString(results));

// Prints:
// RESULTS=[9, 1, 0, 2]