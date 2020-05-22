int colon = time.indexOf(':');
// If we don't have a colon, just assuming it's minutes:seconds in some form
if (colon != -1) {
    int minutes = Integer.parseInt(time.substring(0, colon));
    double seconds = Double.parseDouble(time.substring(colon + 1));
    return minutes * 60 + seconds;
} else {
    return Double.parseDouble(time);
}