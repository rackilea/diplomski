private static long assign() {
    // Assign X
    X = 1;

    // Second assign after method will crash
    return X + 1;
}