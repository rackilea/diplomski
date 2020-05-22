String REGEX_PATTERN_FILE_GROUP = "(\\d{14}_\\d{9}_\\D{3}_\\d{11}_)";

String s = "1.0- 20190409095211_200522007_CNA_20180000959_1_xxxxx.pdf";
Pattern p = Pattern.compile(REGEX_PATTERN_FILE_GROUP);
Matcher m = p.matcher(s);
boolean isMatch = m.find();
System.out.println("isMatch: " + isMatch);
if (isMatch) {
    System.out.println(m.group());
}