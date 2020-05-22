String str = str = "1,1,0,3, '2014-12-02 12:15:13', '2015-05-\\'20', 'string', 'other string', 1,2,1, NULL, '', '', NULL, NULL, NULL";
Pattern p = Pattern.compile("'([^'\\\\]*(?:\\\\.[^'\\\\]*)*)'");
Matcher m = p.matcher(str);

while (m.find()) {
    System.out.println("val: [" + m.group(1) + ']');
}