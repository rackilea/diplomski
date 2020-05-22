public static int countNumbers(String str) {
    final Pattern standaloneNumber = Pattern.compile("(?<=[\\s,])\\d+(?=[\\s,])");
    Matcher matcher = standaloneNumber.matcher(str);
    int pos = 0;
    int count = 0;

    while (matcher.find(pos)) {
        pos = matcher.end();
        count++;
    }

    return count;
}