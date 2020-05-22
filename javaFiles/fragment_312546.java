Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(inputString);

StringBuffer replacedString = new StringBuffer();

while (matcher.find()) {
    matcher.appendReplacement(replacedString, "x");
}

matcher.appendTail(replacedString);