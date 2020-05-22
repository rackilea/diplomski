String str = "Friendlies : International U17 W - 16/04/2014";
Pattern pattern = Pattern.compile("(\\d\\d?/\\d\\d?/\\d{4})");
Matcher m = pattern.matcher(str);
if(m.find()) {
    System.out.println(m.group(1));
}