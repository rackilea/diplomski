String s  = "Peter_NNP";
Pattern p = Pattern.compile(".+_(.*)");
Matcher m = p.matcher(s);
if (m.find()) {
  System.out.println(m.group(1)); //=> "NNP"
}