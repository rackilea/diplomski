public long getTimeInMillis() {
    if (!isTimeSet) {
        updateTime();
    }
    return time;
}