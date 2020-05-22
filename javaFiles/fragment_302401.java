if (lfSum == null || (lfSum != null && sum > lfSum.intValue())) {
    lfSum = sum;
    if (lfSum > lfMax) {
        lfMax = lfSum;
    }
}