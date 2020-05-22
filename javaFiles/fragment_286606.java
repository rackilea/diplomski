String str = "http://this/is/anexample.jpg,http://this/is/anexample.jpg,http://this/is/anexample.jpg,http://this/is/anexample.jpg,http://this/is/anexamplewith.AB.jpg";
Pattern ptrn = Pattern.compile("(?i)http://(?:(?!http://).)*\\.ab\\.(?:(?!http://).)*(?=$|http)");
Matcher matcher = ptrn.matcher(str);
while (matcher.find()) {
    System.out.println(matcher.group(0));
}