// REGEX APPROACH
String str = "f('1132', 'TEXT', '273', '', '2053', 'TEXT', '1081', '0', '0', '', 'TEXT', '',0);";
Matcher m = Pattern.compile("^(?:[^,]*,){4} '(\\d+)'").matcher(str);

if (m.find()) {
    System.out.println(m.group(1));
}