String str = "0 - Amount: 3 - Class 29\n1 - Amount: 2 - Class 21\n2 - Amount: 11 - Class 1";

Pattern pattern = Pattern.compile("Amount: (\\d*) - Class (\\d*)");
Matcher matcher = pattern.matcher(str);

StringBuffer sb = new StringBuffer("{");
while (matcher.find()){
    sb.append(String.format("{%s, %s},", matcher.group(1), matcher.group(2)));
}
sb.setLength(sb.length()-1); // remove last comma
sb.append("}");

System.out.println(sb.toString())