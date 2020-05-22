Pattern pattern = Pattern.compile("\\bActivity\\:(.*)\\bSub-Activity\\:",
        Pattern.DOTALL);
Matcher matcher = pattern.matcher(text);
if (matcher.find()) {
    String activities = matcher.group(1);
    return activities;
}
throw new IllegalStateException("No activity in: " + text);