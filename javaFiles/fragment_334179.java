Pattern pattern = Pattern.compile("\\p{Punct}*(\\w{3,})\\p{Punct}*");
Matcher matcher = pattern.matcher(str);

while(matcher.find()) {
    System.out.print(matcher.group(1) + " ");
}