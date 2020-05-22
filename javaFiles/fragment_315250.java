long time = System.currentTimeMillis() % 3000;
if (time < 1000) {
    return ".";
} else if (time < 2000) {
    return "..";
} else {
    return "...";
}