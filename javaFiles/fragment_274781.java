String regex = "(?:\\brules\\s+\\{|(?!^)\\G)\\s+([\\w-]+)";
final Pattern pattern = Pattern.compile(regex);
Matcher matcher = pattern.matcher(output);
while (matcher.find()) {
    System.out.println(matcher.group(1));
}