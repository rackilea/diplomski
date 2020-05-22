String example = "line1\r\n\r\n\r\nline2";    
Pattern pattern = Pattern.compile("line1(?:\r\n)+(.*)");    
Matcher m = pattern.matcher(example);

if (m.find()) {
  System.out.println(m.group(1));
}