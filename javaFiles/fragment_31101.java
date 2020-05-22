String sTofind = "ingenieur";
String regex = "^((?!>[0-9]+-[0-9]+).*?)(\\b"+ sTofind + "\\b.*)";
String string = "...";
Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
Matcher matcher = pattern.matcher(string);
String result = matcher.replaceAll(subst);