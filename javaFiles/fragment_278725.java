public int strDist(String str, String sub) {
    int firstOccurrence = str.indexOf(sub);
    if (firstOccurrence == -1) { // sub not in str
        return 0;
    }
    int lastOccurrence = str.lastIndexOf(sub);
    return lastOccurrence - firstOccurrence + sub.length();
}