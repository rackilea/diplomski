public static int getConsecutiveNumbers(int [] lottoNumbers) {
    int consecutives = 0;
    // i starts at 1 not 0
    for(int i = 1; i < lottoNumbers.length; i++) {
        // Going through each number here
        if(lottoNumbers[i] - lottoNumbers[i-1] == 1)
            consecutives++; // Numbers were consecutive

    }

    // Return the number of consecutives
    return consecutives;
}