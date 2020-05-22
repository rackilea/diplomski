int readWithinRange(int low, int high) {
    int guess = in.nextInt();
    if (guess >= low && guess <= high)
        return guess;
    else
        return readWithinRange(low, high);
}