String output = "regulations { qux def } standards none rules { abc-123 456-defghi wxyz_678  } security { enabled }"; 
String regex = "(?:\\brules\\s+\\{|(?!^)\\G)\\s+([\\w-]+)";
final Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(output);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}