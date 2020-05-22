public static boolean retry(int maxTries, Runnable r) {
    int tries = 0;
    while (tries != maxTries) {
        try {
            r.run();
            return true;
        } catch (Exception e) {
            tries++;
        }
    }
    return false;
}