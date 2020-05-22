String mystring = "/namestart blabla1 /nameend blabla2";

Pattern p = Pattern.compile("^(/namestart)(.*?)(/nameend)(.*)");
Matcher m = p.matcher(mystring);
if (m.find()) {
    String string1 = m.group(2);
    String string2 = m.group(4);
    System.out.println(string1 + "|" + string2);
}