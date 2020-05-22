String str="#important thing in #any programming #7 #& ";
Pattern MY_PATTERN = Pattern.compile("#(\\S+)");
Matcher mat = MY_PATTERN.matcher(str);
List<String> strs=new ArrayList<String>();
while (mat.find()) {
  //System.out.println(mat.group(1));
  strs.add(mat.group(1));
}