String exp = "\\{(.*?)\\}";

String value = "This {is} a samle {string} that {contains} {substrings} inside curly {braces}";

Pattern pattern = Pattern.compile(exp);
Matcher matcher = pattern.matcher(value);

List<String> matches = new ArrayList<String>(5);
while (matcher.find()) {
    String group = matcher.group();
    matches.add(group);
}

String[] groups = matches.toArray(new String[matches.size()]);
System.out.println(Arrays.toString(groups));