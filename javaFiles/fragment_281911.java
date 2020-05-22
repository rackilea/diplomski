StringBuilder output = new StringBuilder(8);
String input = "1.54.0.21";
Pattern p = Pattern.compile("\\d+");
Matcher matcher = p.matcher(input);
while (matcher.find()) {
    String group = matcher.group();
    if (group.length() < 2) {
        output.append("0");
    }
    output.append(group);
}

System.out.println(input);
System.out.println(output);