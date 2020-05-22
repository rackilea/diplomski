Pattern pattern = Pattern.compile("_[0-9]+ ");
Matcher matcher = pattern.matcher(text);
matcher.find();

// Note the + 1 and - 1 here to get rid of the leading underscore and the trailing space
int number = Integer.parseInt(text.subString(matcher.start() + 1, matcher.end() - 1));