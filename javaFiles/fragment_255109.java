public static long clamp(long delayPreClamp, int min, int max) {
    // v = delayPreClamp
    // if v < min, returns the greater between min and v, thus min
    // if v > max, returns the greater between min and max, thus max
    // if v is between min and max, returns the greater between min and v, thus v
    return Math.max(min, Math.min(delayPreclamp, max));
}