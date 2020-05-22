public Counter(int initialCount) {
    if (initialCount < 0) {
        count = 0;
    } else {
        count = initialCount;
    }
}