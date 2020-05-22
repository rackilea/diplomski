Pattern pattern = Pattern.compile("\"([^\"]+).*");
Matcher matcher = pattern.matcher(line);

if (matcher.matches()) {
    Log.i(TAG, matcher.group(1));  // not group(0)!
} else {
    Log.i(TAG, "no match");
}