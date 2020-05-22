String value = "161207CAD140000,0";
String patt = "[\\d,]+";
Pattern pattern = Pattern.compile(patt);
Matcher matcher = pattern.matcher(value);

while(matcher.find()){

    System.out.println(matcher.group());
}