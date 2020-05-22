final Pattern pattern = Pattern.compile("(?<!%%)(?<=%)\\w+(?=%)(?!%%)");
final Matcher matcher = pattern.matcher(input);

while (matcher.find()) {
    System.out.println(matcher.group(0));
}