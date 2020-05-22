newString = newString.replace("\n", "").replace("\r", "");
Pattern p = Pattern.compile("\\{(.*?)\\}");
Matcher m = p.matcher(newString);
while(m.find()){
    System.out.println(m.group(1).replace(",", " "));
}