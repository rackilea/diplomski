final Pattern pattern = Pattern.compile("(?<!%)(%)(\\w+)(%)(?!%)");
final Matcher matcher = pattern.matcher(input);

while (matcher.find()) {
    System.out.println(matcher.group(1) + " | " + 
                       matcher.group(2) + " | " + 
                       matcher.group(3));
}