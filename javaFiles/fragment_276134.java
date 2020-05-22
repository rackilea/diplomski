static String highestRepeated(String[] str) {
    String[] sorted = Arrays.copyOf(str, str.length);
    Arrays.sort(sorted, 0, sorted.length, Comparator.reverseOrder());
    String currentString = sorted[0];
    String bestString = sorted[0];
    int maxCount = 1;
    int currentCount = 1;
    for (int i = 1 ; i < sorted.length ; i++) {
        if (currentString.equals(sorted[i])) {
            currentCount++;
        } else {
            if (maxCount < currentCount) {
                maxCount = currentCount;
                bestString = currentString;
            }
            currentString = sorted[i];
            currentCount = 1;
        }
    }
    if (currentCount > maxCount) {
        return currentString;
    }
    return bestString;
}