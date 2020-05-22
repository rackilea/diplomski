String helper = "985, 913, 123, SomeotherText, MoreText, MoreText";
Pattern pattern = Pattern.compile("\\b\\d{3}");
Matcher matcher = pattern.matcher(helper);
String newtext = "";

while (matcher.find()) {
    newtext = "Number: " + matcher.group() + "\n"+ newtext;
    helper = helper.replaceAll(matcher.group() + ", ","");
}
newtext = newtext + "________________\n"+ helper;
System.out.println(newtext);