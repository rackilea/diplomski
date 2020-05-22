public static double changeToSpeed(String time, int distance) {
    double totalTime = parseTime(time);
    return distance / totalTime;
}

private static double parseTime(String time) {
    // Now you *only* have to deal with time in here
}