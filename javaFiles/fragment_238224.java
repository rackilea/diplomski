String str = "abc<<1>>def<<2>>ghi";
java.util.Map<Integer,String> replacementMap = new java.util.HashMap<Integer,String>() {
    {
        put(1," ONE ");
        put(2," TWO ");
    }
};
java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("<<([0-9]+)>>");
java.util.regex.Matcher matcher = pattern.matcher(str);
int start = 0;
StringBuffer sb = new StringBuffer();
while(matcher.find()) {
    matcher.appendReplacement(sb,replacementMap.get(Integer.parseInt(matcher.group(1))));
}
matcher.appendTail(sb);
System.out.println(sb.toString());