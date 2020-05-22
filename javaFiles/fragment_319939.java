public static int findNumber(int key, int... numbers) {
    int high = numbers.length - 1;
    int mid = (0 + high) / 2; //replaced low with 0 here
    int rank = 0;
    for (int low = 0; low <= high; mid = (low + high) / 2) {
        if (key < numbers[mid]) {
            high = mid - 1;
        } else if (key > numbers[mid]) {
            low = mid + 1;
        } else {
            rank = mid;
            return rank;
        }
    }
    return rank;
}