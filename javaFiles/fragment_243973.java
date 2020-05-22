public static String getGroup (int average) {
    if (average >= 12 && average < 14) {
        return "Mention AB";
    } else if(average >= 14 && average < 16) {
        return "Mention B";
    } else if (average >= 16) {
        return "Mention TB";
    } else {
        return "No mention";
    }
}