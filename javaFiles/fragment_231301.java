Pattern p = Pattern.compile(".*?(-?\\d+)\\D*$");
String line = "int int0 = (-953);";
Matcher m = p.matcher(line);
if (m.matches()) {
    System.out.println(m.group(1));
}