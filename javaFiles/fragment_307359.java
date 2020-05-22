public String elapsedToString(long elapsedTimeMillis) {
    long seconds = (elapsedTimeMillis + 500) / 1000; // round
    long minutes = seconds / 60;
    long hours = minutes / 60;
    return String.format("%1$02d:%2$02d:%3$02d",
        hours,
        minutes % 60,
        seconds % 60);
}