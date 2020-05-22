String yourString = ...;//place for your string
Pattern p = Pattern.compile("\\p{InHebrew}{2,}");
Matcher m = p.matcher(yourString);

StringBuffer sb = new StringBuffer();

while(m.find()){
    m.appendReplacement(sb, new StringBuilder(m.group()).reverse().toString());
}
m.appendTail(sb);

String reversedSpecial = sb.toString();
System.out.println(reversedSpecial);