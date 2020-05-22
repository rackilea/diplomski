Pattern pattern = Pattern.compile("\"([^\"]+)");
Matcher matcher = pattern.matcher(line);

if (matcher.find()) {
    Log.i(TAG, matcher.group(1));
} else {
    Log.i(TAG, "no match");
}