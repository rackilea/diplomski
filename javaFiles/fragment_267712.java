String rx = "ATG(?:(?!ATG)[ATG]{3})*?(?:TAG|TAA|TGA)";
String s = "ATGTTGTGATGT, ATGATGTTGTGATGT, ATGATGTTGTGATGT";
Pattern pattern = Pattern.compile(rx);
Matcher matcher = pattern.matcher(s);
while (matcher.find()) {
        System.out.println(matcher.group(0));
}