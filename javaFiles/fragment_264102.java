String pattern = "(\\.[a-zA-Z]*|\\.)+";
String input = "http://localhost-tes-folder.mySite.co.us:8080/";
Pattern p = Pattern.compile(pattern);
java.util.regex.Matcher m = p.matcher(input);
if (m.find()) {
    System.out.println(m.group(0));
}