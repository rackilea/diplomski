public String elapsedToString(long elapsedTimeMillis) {
    long hundredths = (elapsedTimeMillis + 5) / 10; // round
    long seconds = hundredths / 100;
    long minutes = seconds / 60;
    return String.format("%1$02d:%2$02d.%3$02d",
        minutes,
        seconds % 60,
        hundredths % 100);
}