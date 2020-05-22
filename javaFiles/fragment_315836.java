final String str = "CREATE TABLE student (id INT, name CHAR(20), gpa DEC);";
final Pattern p = Pattern.compile("(?:\\w+ (?:INT|CHAR(?:\\(\\d{1,3}\\))?|DEC)(?:, )?)+");
final Matcher m = p.matcher(str);
if(m.find()) {
    System.out.println(m.group());  // prints "id INT, name CHAR(20), gpa DEC"
};