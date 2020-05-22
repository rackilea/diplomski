public static String formatMillis(long ms) {
    long rest = ms;
    long minutes = rest / (1000 * 60);

    rest = rest % (1000 * 60);
    long seconds = rest / 1000;
    long millis = rest % 1000;

    return String.format("%02d:%02d:%03d", minutes, seconds, millis);
}