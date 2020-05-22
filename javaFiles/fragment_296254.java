if (colon == 1 || colon == 2) {
    int minutes = Integer.parseInt(time.substring(0, colon));
    double seconds = Double.parseDouble(time.substring(colon + 1));
    return minutes * 60 + seconds;
} else if (colon == -1) {
    return Double.parseDouble(time);
} else {
    throw new /* some appropriate exception type */
}