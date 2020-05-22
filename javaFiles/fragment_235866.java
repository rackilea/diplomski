String s = "key1=value1&key2=value2&key3=&key4=value4";
Pattern p = Pattern.compile("\\w+=[^&]+");
Matcher m = p.matcher(s);
StringBuilder sb = new StringBuilder();
while(m.find()) {
    sb.append(m.group()).append("&");
}
System.out.println(sb.substring(0,sb.length()-1));