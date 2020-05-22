String link = "www.thisisalink.com/tick1=@tick1@&tick2=@tick2@&tick3=@tick3@&tick4=@tick4@";

StringBuffer sb = new StringBuffer();

Pattern p = Pattern.compile("(.+)=@\\1@");
Matcher m = p.matcher(link);
List<String> replaced = new ArrayList<>();

while (m.find()) {
    m.appendReplacement(sb, "");
    replaced.add(m.group());
}
m.appendTail(sb);
//to replace link with String stored in sb use link=sb.toString();
//otherwise link will be unchanged
System.out.println(sb);
System.out.println(replaced);