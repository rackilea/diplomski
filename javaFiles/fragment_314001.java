String patternString = "yy/MM/dd";
Pattern pattern = Pattern.compile("y+|M+|d+");
Matcher matcher = pattern.matcher(patternString);

while (matcher.find()) {
    System.out.println(matcher.group());
}