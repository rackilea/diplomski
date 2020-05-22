Pattern pattern = Pattern.compile("(\d{3}-\d{3})");
Matcher matcher = pattern.matcher("+1-703-535-1039  +1-703-728-8382 +1-703-638-1039  +1-703-535-1039");

// Find all matches
while (matcher.find()) {
    // Get the matching string
    String match = matcher.group();
}