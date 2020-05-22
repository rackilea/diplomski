String input = "<Customer name> <address book >";

Pattern p = Pattern.compile("(<[^>]*?\\s[^>]*?>)");
Matcher m = p.matcher(input);

StringBuffer result = new StringBuffer();

while (m.find()) {
    String replace = m.group().replaceAll("\\s+", "");
    m.appendReplacement(result, replace);
}

m.appendTail(result);
System.out.println(result);